package automatedConstructionSite;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import automatedConstructionSite.Robot.Action;

public class Wall extends Agent {

	// Wall stage of construction
	public static enum Stage {
		EMPTY,
		REINFORCED,
		TUBED,
		PRINTED_CONCRETE,
		POURED_CONCRETE,
		PLUMBED,
		READY
	};
	
	private static List<Color> stageColor = Arrays.asList(
		Color.GRAY,
		Color.RED,
		Color.ORANGE,
		Color.YELLOW,
		Color.GREEN,
		Color.BLUE,
		Color.CYAN
	);
	
	// Agent internal state
	public static enum State {
		AWARDING,
		ASSIGNED,
		SWITCH_PARTICIPANT,
		EXECUTING
	};
	
	private static int[] ActionTime = new int[] {2, 1, 3, 1, 1, 2, 1};
	
	private boolean needsWelding;
	private boolean dynamic;
	private Stage stage;
	
	// Robot selected for a task
	private Robot selectedRobot;
	// Robot that is suitable to substitute the currently selected one
	private Robot robotToSwitchTo;

	private State currentState;
	
	private int messageCount;
	
	public Wall(ContinuousSpace<Object> space, Grid<Object> grid, boolean needsWelding, boolean dynamic) {
		super(space, grid);
		this.needsWelding = needsWelding;
		this.stage = Stage.EMPTY;
		this.currentState = State.AWARDING;
		this.selectedRobot = null;
		this.robotToSwitchTo = null;
		this.messageCount = 0;
		this.dynamic = dynamic;
	}
	
	public int getMessageCount() {
		return this.messageCount;
	}
	
	public GridPoint getLocation() {
		return this.grid.getLocation(this);
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public State getState() {
		return this.currentState;
	}
	
	private void nextStage() {
		this.currentState = Wall.State.AWARDING;
		if (this.stage == Stage.READY)
			return;
		this.stage = Stage.values()[this.stage.ordinal() + 1];
	}
	
	public boolean isBusy() {
		return this.busy;
	}
	
	
	/**
	 * Returns the ticks that takes for an action to be completed.
	 * @param action
	 * @return
	 */
	public static int getActionTime(Action action) {
		return Wall.ActionTime[action.ordinal()];
	}
	
	/**
	 * Applies an Action to the Wall
	 * @param action the Action to apply
	 * @return True if the action has started correctly; False otherwise.
	 */
	public boolean applyAction(Action action) {
		// If the Wall is busy, an action is already being applied
		if (this.busy) {
			return false;
		} else {
			// If the action can be applied to the current state, proceed
			if (action.ordinal() == this.stage.ordinal()) {
				this.busy = true;
				this.busyTime = Wall.getActionTime(action);
				this.currentState = Wall.State.EXECUTING;
				return true;
			} else {
				return false;
			}
		}
	}
	
	private Set<Robot> getRobots() {
		GridCellNgh<Robot> robotQuery = new GridCellNgh<>(grid, this.getLocation(), Robot.class, this.grid.getDimensions().getWidth(), this.grid.getDimensions().getHeight());
		List<GridCell<Robot>> robotCells = robotQuery.getNeighborhood(true);
		// Filter
		Set<Robot> robots = new HashSet<Robot>();
		for (GridCell<Robot> cell : robotCells) {
			for (Robot r : cell.items()) {
				if (r.isActionAllowed(this)) {
					robots.add(r);
				}
			}
		}
		
		return robots;
	}
	
	@ScheduledMethod(start = 1, interval = 1, shuffle = true, priority = Agent.FIRST_PRIORITY)
	public void stepOne() {
		if (this.busy) {
			this.busyTime--;
			if (this.busyTime <= 0) {
				this.busy = false;
				this.nextStage();
			}
		}
		
		if (this.stage == Wall.Stage.READY) {
			return;
		}
		
		if (this.currentState == Wall.State.AWARDING) {
			//System.out.println("Wall " + this.stage.toString() + " " + this.getLocation().toString() + " sends CFP to:");
			// 1. Search robots with task == current stage
			// 2. Send them a message with CFP
			Set<Robot> robots = this.getRobots();
			for (Robot r : robots) {
				Message message = new Message(this, "", Message.Performative.CALL_FOR_PROPOSAL);
				r.sendMessage(message);
				this.messageCount++;
				//System.out.println(r.getLocation());
			}
		} else if (this.currentState == Wall.State.ASSIGNED) {
			if (this.dynamic) {
				// 1. Send CFP to other robots, hoping for a best offer
				Set<Robot> robots = this.getRobots();
				for (Robot r : robots) {
					if (!r.equals(this.selectedRobot)) {
						Message message = new Message(this, "", Message.Performative.CALL_FOR_PROPOSAL);
						r.sendMessage(message); 
						this.messageCount++;
					}
				}
			}
		}
		
	}
	
	@ScheduledMethod(start = 1, interval = 1, shuffle = true, priority = Agent.THIRD_PRIORITY)
	public void stepThree() {
		
		if (this.stage == Wall.Stage.READY) {
			return;
		}
		
		if (this.currentState == Wall.State.AWARDING) {
			// Answer possible offers made in response to CALL_FOR_PROPOSAL
			Robot candidate = null;
			double bestDistance = Double.MAX_VALUE;
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.PROPOSE) {
					// This is an offer message
					if ((double) message.content < bestDistance) {
						bestDistance = (double) message.content;
						candidate = (Robot) message.sender;
					}
				}
			}
			
			if (candidate != null) {
				// Notify the provisional winner
				Message assignMessage = new Message(
					this,
					bestDistance,
					Message.Performative.ACCEPT_PROPOSAL
				);
				candidate.sendMessage(assignMessage);
				this.messageCount++;
			}
		} else if (this.currentState == Wall.State.ASSIGNED && this.dynamic) {
			// If the robot that is assigned to this wall were within action radius,
			// it would have changed the wall state to EXECUTING.
			// Then, it is safe to consider better offers.
			Robot switchTo = null;
			double bestDistance = this.distanceTo(this.selectedRobot);
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.PROPOSE) {
					// This is an offer message
					if ((double) message.content < bestDistance) {
						bestDistance = (double) message.content;
						switchTo = (Robot) message.sender;
					}
				}
			}
			if (switchTo != null) {
				// There is a better offer. Notify the provisional winner.
				// Later, if the provisional winner confirms the switch,
				// abort currently selected robot.
				Message switchMessage = new Message(
					this,
					bestDistance,
					Message.Performative.ACCEPT_PROPOSAL
				);
				switchTo.sendMessage(switchMessage);
				this.messageCount++;
				this.robotToSwitchTo = switchTo;
				this.currentState = Wall.State.SWITCH_PARTICIPANT;
			}
		}
	}
	
	@ScheduledMethod(start = 1, interval = 1, shuffle = true, priority = Agent.LAST_PRIORITY)
	public void stepFive() {
		if (this.stage == Wall.Stage.READY) {
			return;
		}
		
		// Here, the agent just checks whether it has to update its internal state
		if (this.currentState == Wall.State.AWARDING) {
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.performative == Message.Performative.INFORM && message.content != null && message.content.equals("taskStarted")) {
					this.currentState = Wall.State.ASSIGNED;
					this.selectedRobot = (Robot) message.sender;
				}
			}
		} else if (this.currentState == Wall.State.SWITCH_PARTICIPANT) {
			while (!this.messageQueue.isEmpty()) {
				Message message = this.messageQueue.poll();
				if (message.sender.equals(this.robotToSwitchTo)) {
					if (
						message.performative == Message.Performative.INFORM
						&& message.content != null
						&& message.content.equals("taskStarted")
					) {
						// Abort the task of the previous robot
						this.selectedRobot.abort();
						this.selectedRobot = (Robot) message.sender;
						this.currentState = Wall.State.ASSIGNED;
					} else {
						// The robot to switch to has not confirmed.
						// Stick with the current one.
						this.currentState = Wall.State.ASSIGNED;
					}
				}
			}
		}
		// if currentState == ASSIGNED, there is no need to do anything
	}

	public void retract() {
		this.selectedRobot = null;
		this.currentState = Wall.State.AWARDING;
	}

	public Color getColor() {
		return Wall.stageColor.get(this.stage.ordinal());
	}
	
	
	
}