import java.util.ArrayList;

public class RaceConditionTest implements Runnable {
	
	private Counter c;
	
	public RaceConditionTest(Counter c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.increment();
		c.decrement();
		c.increment();
		c.decrement();
	}


	public static void main(String[] args) throws Exception {       
    
		Counter  counter = new Counter(); // one counter shared across all threads
		
		Thread[] threads = new Thread[500];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new RaceConditionTest(counter));
		}
		for(Thread t : threads) {
			t.start();
		}
		System.out.println("Number of Threads: " + Thread.activeCount());
		for(Thread t : threads) {
			t.join();
		}
		System.out.println("Counter should still be 0: " + counter);

	}

}
