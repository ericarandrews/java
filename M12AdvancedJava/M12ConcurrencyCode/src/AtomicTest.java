
public class AtomicTest implements Runnable {
	
	private AtomicCounter atomicCounter;
	
	public AtomicTest(AtomicCounter c) {
		this.atomicCounter = c;
	}
	
	@Override
	public void run() {
		atomicCounter.increment();
		atomicCounter.decrement();
	    atomicCounter.increment();
	    atomicCounter.decrement();
	}


	
	public static void main(String[] args) throws Exception {
		AtomicCounter  counter = new AtomicCounter();
		Thread[] threads = new Thread[5000];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new AtomicTest(counter));
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
