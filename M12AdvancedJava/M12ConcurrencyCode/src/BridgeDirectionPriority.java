import java.util.concurrent.locks.*;

public class BridgeDirectionPriority implements BridgeInterface {

	private Lock bridgeLock;
	private boolean goingEast, goingWest;
	private int needToGoEast, needToGoWest;
	private Condition correctDirectionCondition;

	public BridgeDirectionPriority() {
		bridgeLock = new ReentrantLock();
		goingEast = true;
		goingWest = !goingEast;
		needToGoEast = 0;
		needToGoWest = 0;
		correctDirectionCondition = bridgeLock.newCondition();
	}
	
	public void cross(CarThread car) {
		System.out.println(car.getName() + "\tARRIVED to cross " + car.getDirection());
		
		synchronized(this) {
			if(car.isGoingEast()) {
				needToGoEast++;
			} else {
				needToGoWest++;
			}
		}
		bridgeLock.lock();
		System.out.println(car.getName() + "\tOBTAINED THE LOCK ");

		try {
			while(! (goingCorrectDirection(car) || timeToSwitch())) {
				System.out.println(car.getName() + "\tCANNOT CROSS... will RELEASE LOCK and wait to cross " + car.getDirection());
				correctDirectionCondition.await();
			}
			
			if(timeToSwitch()) {
				switchBridgeDirection();
			}
			System.out.println(car.getName() + "\tBEGINNING to cross "
					+ car.getDirection() + " for " + car.getTimeToCross() + " seconds...");
			Thread.sleep(car.getTimeToCross()*1000);
			System.out.println(car.getName() + "\tFINISHED crossing " + car.getDirection());
			
			synchronized(this) {
				if(car.isGoingEast()) {
					needToGoEast--;
				} else {
					needToGoWest--;
				}
			}		
			correctDirectionCondition.signalAll();
		} catch(InterruptedException ex) {
		} finally {
			System.out.println(car.getName() + "\tRELEASING THE LOCK ");
			bridgeLock.unlock();
		}
	}
	
	private boolean timeToSwitch() {
		return goingEast && needToGoEast==0 ||
			goingWest && needToGoWest ==0;
	}
	
	private boolean goingCorrectDirection(CarThread car) {
		return goingEast && car.isGoingEast() ||
			goingWest && car.isGoingWest();
	}
	
	private void switchBridgeDirection() {
		if (timeToSwitch()) {
			synchronized(this) {
				goingEast = !goingEast;
				goingWest = !goingWest;
				System.out.println("\nBridge is switching directions! Bridge is now going " + getDirection());
			}
		}
	}
	
	public String getDirection() {
		return goingEast ? "EAST" : "WEST";
	}
	
	public int getNeedToGoEast() {
		return needToGoEast;
	}
	public int getNeedToGoWest() {
		return needToGoWest;
	}

}
