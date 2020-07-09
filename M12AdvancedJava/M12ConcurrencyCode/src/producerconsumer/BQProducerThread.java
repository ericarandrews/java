package producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BQProducerThread implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public BQProducerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
            try {
                int number = (new Random()).nextInt(100);
                queue.put(number); // put will wait, add will throw an exception when the queue is full
                System.out.println("Producer\tadding " + number + " to the box");
	            
                System.out.println("Producer \tsleeping");
	            Thread.sleep((new Random()).nextInt(5000));
	            System.out.println("Producer \tawake");
            } catch (InterruptedException ex) { }
		}
	}

}
