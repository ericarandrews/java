
public class CarThread implements Runnable {
	
	private String name;
	private boolean goingEast;
	private int timeToCross;
	private BridgeInterface bridge;
	
	public CarThread(String name, boolean goingEast, int timeToCross, BridgeInterface bridge) {
		this.name = name;
		this.goingEast = goingEast;
		this.timeToCross = timeToCross;
		this.bridge = bridge;
	}
	
	public String getName() {
		return name;
	}	
	public boolean isGoingEast() {
		return goingEast;
	}
	public boolean isGoingWest() {
		return !goingEast;
	}
	public int getTimeToCross() {
		return timeToCross;
	}
	public String getDirection() {
		return isGoingEast() ? "EAST" : "WEST";
	}	
	@Override
	public void run() {
		bridge.cross(this); 
	}
	
	


}
