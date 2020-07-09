public class CircularLinkedQueue<T> implements QueueInterface<T> {
	private Node lastNode;

	public CircularLinkedQueue() {
		lastNode = null;
	}

	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);

		if (isEmpty()) {
			newNode.next = newNode;
			lastNode = newNode;
		} else {
			Node firstNode = lastNode.next;
			newNode.next = firstNode;
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}

	public T getFront() {
		T front = null;

		if (!isEmpty()) {
			Node firstNode = lastNode.next;
			front = firstNode.data;
		}
		return front;
	}

	public T dequeue() {
		T front = null;

		if (!isEmpty()) {
			Node firstNode = lastNode.next;
			front = firstNode.data;
			if (lastNode == firstNode) {
				lastNode = null;
			} else {
				lastNode.next = firstNode.next;
			}

		}
		return front;

	}

	public boolean isEmpty() {
		return lastNode == null;
	}

	public void clear() {
		lastNode = null;
	}

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		}

	}

	public static void main(String[] args) {
		System.out.println("Create a queue: ");
		QueueInterface<String> myQueue = new CircularLinkedQueue<String>();
		System.out.println("\n\nisEmpty() returns " + myQueue.isEmpty() + "\n");

		System.out.println("Add to queue to get\n" + "Joe Jess Jim Jill Jane Jerry\n");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");
		myQueue.enqueue("Jill");
		myQueue.enqueue("Jane");
		myQueue.enqueue("Jerry");

		System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n");

		System.out.println("\n\nTesting getFront and dequeue:\n");
		while (!myQueue.isEmpty()) {
			String front = myQueue.getFront();
			System.out.println(front + " is at the front of the queue.");

			front = myQueue.dequeue();
			System.out.println(front + " is removed from the front of the queue.\n");
		} // end while

		System.out.print("\nThe queue should be empty: ");
		System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n\n");

		System.out.println("Add to queue to get\n" + "Joe Jess Jim\n");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");

		System.out.println("\nTesting clear:\n");
		myQueue.clear();

		System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n\n");

		System.out.println("Add to queue to get\n" + "Joe Jess Jim\n");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");

		while (!myQueue.isEmpty()) {
			String front = myQueue.getFront();
			System.out.println(front + " is at the front of the queue.");

			front = myQueue.dequeue();
			System.out.println(front + " is removed from the front of the queue.\n");
		} // end while

		System.out.print("\n\nThe queue should be empty: ");
		System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n");

		System.out.println("myQueue.getFront() returns " + myQueue.getFront());
		System.out.println("myQueue.dequeue() returns " + myQueue.dequeue() + "\n");
	} // end main
} // end CircularLinkedQueue
