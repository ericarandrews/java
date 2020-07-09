
public class ThreadPractice {

	public static void main(String[] args) throws InterruptedException {
		
	    /*
		System.out.println(Thread.currentThread());
		int threadCount = Thread.activeCount();
		System.out.println(threadCount);
		
		// Thread.sleep example
		for(int i=0; i<5; i++) {
			System.out.println("Hello threaded world! before " + i);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException ex) {}
			System.out.println("Hello threaded world! after " + i);

		}
		*/
	    
	    // non-threaded (actually single-threaded- the main thread) version
	//	DatePrintNonThread datePrintNonThreaded = new DatePrintNonThread(2000,5);
	//	datePrintNonThreaded.run();
		
	    // multi-threaded version that uses inheritance (extends Thread)
	//	Thread datePrinterThreaded = new DatePrintThread(2000, 5);
	//	datePrinterThreaded.start(); // CRITICAL! INVOKE start, NOT run!

	    // multi-threaded version that uses interface (implements Runnable)
	    Thread datePrintRunnable =	new Thread(new DatePrintRunnable(2000, 5)); // parameter to the Thread constructor- our Runnable object
		datePrintRunnable.start(); // CRITICAL! invoke start() not run()
		
		/*
		Thread.sleep(3000); // sleep the main thread to wait for the interrupt to be called
		datePrintRunnable.interrupt();
		System.out.println("after interrupt- interrupt was called");
		*/
		
		// tells the current thread (main) to wait until datePrinterThreaded is done
		datePrintRunnable.join();
		
		
		System.out.println("code that is after time printing");
		System.out.println("let's print some other things");
		for(int i=0; i<5; i++) {
		    System.out.println("***");
		    Thread.sleep(2000);
		}
		System.out.println();
		
	
		

		

		

		
	
		
	}

}
