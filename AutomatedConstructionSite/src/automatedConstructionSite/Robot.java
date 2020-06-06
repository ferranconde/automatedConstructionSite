package automatedConstructionSite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.space.SpatialMath;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;
import pathfinder.AStar;
import pathfinder.Node;
import repast.simphony.util.collections.Pair;

public class Robot extends Agent {

	public static enum Action {
		REINFORCE,
		TUBE,
		PRINT_CONCRETE,
		POUR_CONCRETE,
		PLUMB,
		WELD,
		SURVEY
	};
	
	private static List<Color> stageColor = Arrays.asList(
		Color.RED,
		Color.ORANGE,
		Color.YELLOW,
		Color.GREEN,
		Color.BLUE,
		Color.CYAN,
		Color.PINK
	);
	
	// Agent internal state
	public static enum State {
		VOTING,
		INTENTIONAL,
		SWITCH_INITIATOR,
		EXECUTE
	};
	
	private Action action;
	private int searchRadius;
	private double actionRadius;
	private GridPoint basePoint;
	private Wall selectedWall;
	private boolean dynamic;
	
	private int messageCount;
	
	private State currentState;
	
	private Queue<Node> currentPath;
	
	public Robot(ContinuousSpace<Object> space, Grid<Object> grid, Action action, boolean dynamic) {
		super(space, grid);
		this.action = action;
		this.searchRadius = 10;
		this.actionRadius = 0.5;
		this.basePoint = new GridPoint(5, 5);
		this.selectedWall = null;
		this.currentState = State.VOTING;
		this.messageCount = 0;
		this.dynamic = dynamic;
	}
	
	public int getMessageCount() {
		return this.messageCount;
	}
	
	public boolean isActionAllowed(Wall w) {
		return w.getStage().ordinal() == this.action.ordinal();
	}
	
	public GridPoint getLocation() {
		return this.grid.getLocation(this);
	}
	
	public boolean isBusy() {
		return this.busy;
	}
	
	public State getState() {
		return this.currentState;
	}
	
	public void moveTo(GridPoint pt) {
		if (!pt.equals(this.getLocation())) {
			NdPoint myPoint = this.space.getLocation(this);
			NdPoint otherPoint = new NdPoint(pt.getX(), pt.getY());
			double angle = SpatialMath.calcAngleFor2DMovement(this.space, myPoint, otherPoint);
			double dist = this.space.getDistance(myPoint, otherPoint);
			this.space.moveByVector(this, Math.min(dist, 1), angle, 0);
			myPoint = this.space.getLocation(this);
			this.grid.moveTo(this, (int) myPoint.getX() ,(int) myPoint.getY());
		}
	}

	
	private List<Pair<Integer, Integer>> getAir() {
		Context<Object> context = (Context<Object>) ContextUtils.getContext(this);
		List<Pair<Integer, Integer>> mapAir = null;
		for (Object o : context.getObjects(List.class)) {
			mapAir = (List<Pair<Integer, Integer>>) o;
		}
		
		return mapAir;
		
	}
	
	
	// This method uses AStar to calculate a path to the goal
	private List<Node> findPath(GridPoint pt) {
		// Node works like (row, col), so it is (y, x)
		AStar aStar = new AStar(
			this.grid.getDimensions().getHeight(),
			this.grid.getDimensions().getWidth(),
			new Node(this.getLocation().getY(), this.getLocation().getX()),
			new Node(pt.getY(), pt.getX())
		);
		
		// Get all Walls to get block nodes
		GridCellNgh<Wall> wallQuery = new GridCellNgh<>(
			grid, 
			new GridPoint(grid.getDimensions().getWidth() / 2, grid.getDimensions().getHeight() / 2),
			Wall.class,
			grid.getDimensions().getWidth(),
			grid.getDimensions().getHeight()
		);
		List<GridCell<Wall>> wallCells = wallQuery.getNeighborhood(true);
		for (GridCell<Wall> cell : wallCells) {
			for (Wall w : cell.items()) {
				/*
				if (w.getStage() != Wall.Stage.EMPTY) {
					aStar.setBlock(w.getLocation().getY(), w.getLocation().getX());
				}
				*/
				aStar.setBlock(w.getLocation().getY(), w.getLocation().getX());
			}
		}
		
		for (Pair<Integer, Integer> airpos : this.getAir()) {
			aStar.setBlock(airpos.getSecond(), airpos.getFirst());
		}
		
		List<Node> path = aStar.findPath();
		return path;
	}
	
	
	private List<Wall> getReachableWalls() {
		// 1.
		GridCellNgh<Wall> wallQuery = new GridCellNgh<>(grid, this.getLocation(), Wall.class, this.searchRadius, this.searchRadius);
		List<GridCell<Wall>> wallCells = wallQuery.getNeighborhood(true);
		// Filter
		List<Wall> reachableWalls = new ArrayList<Wall>();
		for (GridCell<Wall> cell : wallCells) {
			for (Wall w : cell.items()) {
				if (!w.isBusy() && isActionAllowed(w)) {
					reachableWalls.add(w);
				}
			}
		}
		
		return reachableWalls;
	}
	
	
	@ScheduledMethod(start = 1, interval = 1, shuffle = true, priority = Agent.SECOND_PRIORITY)
	public void stepTwo() {
		if (this.busy) {
			this.busyTime--;
			if (this.busyTime <= 0) {
				this.busy = false;
				this.selectedWall = null;
				this.currentState = Robot.State.VOTING;
			}
		}
		
		// If the robot is busy executing the task, focus only on that
		if (this.busy)
			return;
		
		if (this.currentState == Robot.State.VOTING) {
			// In Voting state, we wait for CFP messages and we answer them
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.CALL_FOR_PROPOSAL
					&& this.isActionAllowed((Wall) message.sender)) {
					// Make an offer
					Message offerMessage = new Message(
						this,
						this.distanceTo(message.sender),
						Message.Performative.PROPOSE
					);
					message.sender.sendMessage(offerMessage);
					this.messageCount++;
				}
			}
		} else if (this.currentState == Robot.State.INTENTIONAL) {
			Node dest = this.currentPath.poll();
			if (dest == null) {
				this.moveTo(this.selectedWall.getLocation());
			} else {
				this.moveTo(new GridPoint(dest.getCol(), dest.getRow()));
			}
			// Check if wall is within bounds so task can be executed
			if (this.distanceTo(selectedWall) < this.actionRadius) {
				this.busy = selectedWall.applyAction(this.action);
				if (this.busy) {
					this.busyTime = Wall.getActionTime(this.action);
					this.currentState = Robot.State.EXECUTE;
				}
			}
			if (!this.busy) {
				// If the robot is not actually executing the task, it can answer CFPs
				while (!this.messageQueue.isEmpty()) {
					Message message = this.messageQueue.poll();
					if (
						message.performative == Message.Performative.CALL_FOR_PROPOSAL
						&& this.isActionAllowed((Wall) message.sender)
						&& this.dynamic
					) {
						// Make an offer ONLY IF the offer is better
						double offerDistance = this.distanceTo(message.sender);
						if (offerDistance < this.distanceTo(this.selectedWall)) {
							Message offerMessage = new Message(
								this,
								this.distanceTo(message.sender),
								Message.Performative.PROPOSE
							);
							message.sender.sendMessage(offerMessage);
							this.messageCount++;
						}
					}
				}
			}
		}
		
	}
	
	@ScheduledMethod(start = 1, interval = 1, shuffle = true, priority = Agent.FOURTH_PRIORITY)
	public void stepFour() {
		if (this.currentState == Robot.State.VOTING) {
			// In Voting state, we wait for ACCEPT_PROPOSAL messages
			Wall assigned = null;
			double bestDistance = Double.MAX_VALUE;
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.ACCEPT_PROPOSAL
					&& this.isActionAllowed((Wall) message.sender)) {
					if ((double) message.content < bestDistance) {
						bestDistance = (double) message.content;
						assigned = (Wall) message.sender;
					}
				}
			}
			// Send a message to the Wall, saying that the task is started
			if (assigned != null) {
				Message taskStartedMessage = new Message(
					this,
					"taskStarted",
					Message.Performative.INFORM
				);
				assigned.sendMessage(taskStartedMessage);
				this.messageCount++;
				this.selectedWall = assigned;
				this.currentPath = new LinkedList<Node>();
				this.currentPath.addAll(this.findPath(this.selectedWall.getLocation()));
				// Switch internal state
				this.currentState = Robot.State.INTENTIONAL;
			}
		} else if (this.currentState == Robot.State.INTENTIONAL && this.dynamic) {
			// If a better ACCEPT_PROPOSAL message has arrived, retract and switch
			// Choose from these ACCEPT_PROPOSAL messages
			Wall switchTo = null;
			double bestDistance = this.distanceTo(this.selectedWall);
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.ACCEPT_PROPOSAL
					&& this.isActionAllowed((Wall) message.sender)) {
					if ((double) message.content < bestDistance) {
						bestDistance = (double) message.content;
						switchTo = (Wall) message.sender;
					}
				}
			}
			// There is a better Wall. Notify the wall that the task has started.
			if (switchTo != null) {
				Message taskStartedMessage = new Message(
					this,
					"taskStarted",
					Message.Performative.INFORM
				);
				switchTo.sendMessage(taskStartedMessage);
				this.messageCount++;
				// Retract from the previous wall
				this.selectedWall.retract();
				this.selectedWall = switchTo;
			}
		}
	}

	public void abort() {
		this.selectedWall = null;
		this.currentState = Robot.State.VOTING;
	}

	public Color getColor() {
		return Robot.stageColor.get(this.action.ordinal());
	}
	
}
