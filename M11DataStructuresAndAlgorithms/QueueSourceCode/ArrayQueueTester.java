import java.util.Arrays;

public class ArrayQueueTester {

	public static void main(String[] args) {
		// *** to use, temporarily make the queue in ArrayQueue public
		ArrayQueue<String> wordQueue = new ArrayQueue<String>(5);
		wordQueue.enqueue("amps");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("bank");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("card");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.dequeue();
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("door");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("ever");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.dequeue();
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("frog");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("golf");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.dequeue();
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("hats");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());
		wordQueue.enqueue("iris");
		System.out.println(Arrays.toString(wordQueue.queue) + "\tFront=" + wordQueue.getFront());

	}

}
