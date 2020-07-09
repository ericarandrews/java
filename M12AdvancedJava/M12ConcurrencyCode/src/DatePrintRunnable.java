import java.time.*;

public class DatePrintRunnable implements Runnable {

	private int delay;
	private int times;
	
	public DatePrintRunnable(int delay, int times) {
		this.delay = delay;
		this.times = times;
	}
	
	@Override
	public void run() {
		for(int i=0; i<times; i++) { // "while more work to be done"
			try {
			    if(!Thread.interrupted()) { // handle an interrupt that happens when the thread is awake- will also clear the flag if interuppted
			  //  if(!Thread.currentThread().isInterrupted()) { // will check to see if interuppted, but the flag is never cleared- once interuppted, forever interuppted!
			        System.out.println("In Runnable time " + i + ": " + LocalTime.now());
			    } else {
			        System.out.println("Missed " + i + " because of interruption");
			        //return;
			    }
				Thread.sleep(delay);
			} catch(InterruptedException ex) {
	             System.out.println("DatePrintRunnable has been interrupted while sleeping");
	             return; // ends the run method, which in turn terminates the thread
			}
		}
	}
}
