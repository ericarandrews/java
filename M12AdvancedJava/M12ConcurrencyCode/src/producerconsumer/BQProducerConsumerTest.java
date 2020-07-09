package producerconsumer;

import java.util.concurrent.*;

public class BQProducerConsumerTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2); // 1 would be analogous to the NumberBox example
		
		Thread producerThread = new Thread(new BQProducerThread(queue));
		Thread consumerThread = new Thread(new BQConsumerThread(queue));
		
		producerThread.start();
		consumerThread.start();

	}

}
