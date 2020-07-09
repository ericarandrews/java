import java.util.*;

public class BridgeTesterThread implements Runnable {

	// range of time for a car to cross the bridge
	private static final int MIN_CROSS_TIME = 3, MAX_CROSS_TIME = 7;
	
	// range of time in between new cars arriving
	private static final int MIN_BREAK_TIME = 1, MAX_BREAK_TIME = 4;
	
	private static BridgeInterface bridge;
	
	public static void main(String[] args) throws Exception {
		//bridge = new BridgeNoDirection();
		bridge = new BridgeDirectionPriority();
		
		// this thread is only here to display the time and number of cars at the bridge
		Thread testerThread = new Thread(new BridgeTesterThread()); 
		testerThread.start();
		
		Random generator = new Random();
		int numberOfCars = 10;
		for(int i=0; i<numberOfCars; i++) {
			char nameLetter = (char) (i + 65);
			String name = "" + nameLetter + nameLetter + nameLetter;
			int crossTime = generator.nextInt(MAX_CROSS_TIME - MIN_CROSS_TIME + 1) + MIN_CROSS_TIME;
			CarThread car = new CarThread(name, generator.nextBoolean(), crossTime, bridge);
			Thread carThread = new Thread(car);
			carThread.start();
			int breakTime = generator.nextInt(MAX_BREAK_TIME - MIN_BREAK_TIME + 1) + MIN_BREAK_TIME;
			Thread.sleep(breakTime * 1000);
		}
	
	}
	
	@Override
	public void run() {
		int programTimeCounter=0;
		while(Thread.activeCount()>2 || programTimeCounter <= MAX_BREAK_TIME+1 ) {
			//System.out.println("TIME " + programTimeCounter  + "\tTotal Cars: " + (Thread.activeCount()-2));
			System.out.println("TIME " + programTimeCounter  + "\tEastBound: " + ((BridgeDirectionPriority)bridge).getNeedToGoEast() + "\tWestBound: " + ((BridgeDirectionPriority)bridge).getNeedToGoWest() + "\tBridge Direction: " + ((BridgeDirectionPriority)bridge).getDirection() );
			programTimeCounter++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				
			}
		}

		
	}

}
