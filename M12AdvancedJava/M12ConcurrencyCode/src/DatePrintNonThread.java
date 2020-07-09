import java.time.LocalTime;

public class DatePrintNonThread {

	private int delay;
	private int times;
	
	public DatePrintNonThread(int delay, int times) {
		this.delay = delay;
		this.times = times;
	}
	

	public void run() {
		for(int i=0; i<times; i++) {
			try {
			    System.out.println("In non-threaded time " + i + ": " + LocalTime.now());
				Thread.sleep(delay);
			} catch(InterruptedException ex) {}
		}
	}
}
