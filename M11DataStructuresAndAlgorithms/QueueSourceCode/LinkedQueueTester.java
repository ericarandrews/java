public class LinkedQueueTester {

	public static void main(String[] args) {
		// *** to use, temporarily make the firstNode and lastNode in LinkedQueue public 
		// (note I also made parts of the Node class public)
		LinkedQueue<String> wordQueue = new LinkedQueue<String>();
		
		printQueue(wordQueue);
		wordQueue.enqueue("amps");
		printQueue(wordQueue);
		wordQueue.enqueue("bank");
		wordQueue.enqueue("card");
		printQueue(wordQueue);
		wordQueue.dequeue();
		printQueue(wordQueue);
		wordQueue.enqueue("door");
		wordQueue.enqueue("ever");
		printQueue(wordQueue);
		wordQueue.dequeue();
		printQueue(wordQueue);
		wordQueue.enqueue("frog");
		wordQueue.enqueue("golf");
		wordQueue.dequeue();
		printQueue(wordQueue);
		wordQueue.enqueue("hats");
		wordQueue.enqueue("iris");
		printQueue(wordQueue);
		wordQueue.dequeue();
		wordQueue.dequeue();
		wordQueue.dequeue();
		wordQueue.dequeue();
		printQueue(wordQueue);
		wordQueue.dequeue();
		printQueue(wordQueue);
		wordQueue.dequeue();
		printQueue(wordQueue);
	}

	private static void printQueue(LinkedQueue queue) {
		
		LinkedQueue.Node current = queue.firstNode;
		if(current==null) {
			System.out.println("Front: null \tBack: null");
		} else {
			System.out.print("Front: " + queue.firstNode.data + "\tBack: " + queue.lastNode.data+"\t");
			while(current.next != null) {
				System.out.print(current.data + "->");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}
	
}