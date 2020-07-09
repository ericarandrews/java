import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest implements Runnable {
	
	private LongAdder longAdder;
	
	public LongAdderTest(LongAdder counter) {
		this.longAdder = counter;
	}
	
	@Override
	public void run() {
		longAdder.increment();
	    longAdder.decrement();
	    longAdder.increment();
	    longAdder.decrement();
	}

	public static void main(String[] args) throws Exception {
		LongAdder  counter = new LongAdder();
		Thread[] threads = new Thread[5000];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new LongAdderTest(counter));
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
