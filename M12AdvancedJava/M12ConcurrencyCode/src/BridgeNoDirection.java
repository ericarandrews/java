import java.util.concurrent.locks.*;

public class BridgeNoDirection implements BridgeInterface {

	private Lock bridgeLock;

	public BridgeNoDirection() {
		bridgeLock = new ReentrantLock();
	}
	
	public void cross(CarThread car) {
		System.out.println(car.getName() + " has ARRIVED to cross the bridge going " + car.getDirection() + ".");
		bridgeLock.lock();
		try {
			System.out.println(car.getName() + " is BEGINNING to cross the bridge going " + car.getDirection() 
				+ " for " + car.getTimeToCross() + " seconds.");
			Thread.sleep(car.getTimeToCross()*1000);
			System.out.println(car.getName() + " has FINISHED crossing the bridge.");
		} catch(InterruptedException ex) {
		} finally {
			bridgeLock.unlock();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
// 
//	
//	


}
