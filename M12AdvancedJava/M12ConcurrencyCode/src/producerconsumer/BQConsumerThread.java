package producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BQConsumerThread implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public BQConsumerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	 @Override
	    public void run() {
	        for (int i = 0; i < 10; i++) {
	            try {
	                int number = queue.take(); // take will wait, remove will throw an exception when the queue is empty
	                System.out.println("Consumer\tretreiving " + number + " for processing");

	                System.out.println("Consumer \tsleeping");
	                Thread.sleep((new Random()).nextInt(5000));
	                System.out.println("Consumer \tawake");
	            } catch (InterruptedException ex) { }
	        }
	    }

}
