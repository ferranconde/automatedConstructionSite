package automatedConstructionSite;

import java.util.LinkedList;

import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

public abstract class Agent {

	public static final double FIRST_PRIORITY = Double.POSITIVE_INFINITY;
	public static final double SECOND_PRIORITY = 1000;
	public static final double THIRD_PRIORITY = 999;
	public static final double FOURTH_PRIORITY = 998;
	public static final double LAST_PRIORITY = Double.NEGATIVE_INFINITY;
	
	public LinkedList<Message> messageQueue;
	protected ContinuousSpace<Object> space;
	protected Grid<Object> grid;
	protected boolean busy;
	protected int busyTime;
	
	public Agent(ContinuousSpace<Object> space, Grid<Object> grid) {
		this.space = space;
		this.grid = grid;
		this.busy = false;
		this.busyTime = 0;
		this.messageQueue = new LinkedList<Message>();
	}
	
	public void sendMessage(Message message) {
		this.messageQueue.add(message);
	}
	
	public double distanceTo(Agent agent) {
		return this.grid.getDistance(this.grid.getLocation(this), this.grid.getLocation(agent));
	}
	
}
