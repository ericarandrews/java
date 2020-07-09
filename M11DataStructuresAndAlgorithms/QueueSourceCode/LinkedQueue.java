/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	public Node firstNode;
	public Node lastNode; 

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	} 

	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);

		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}

		lastNode = newNode;
	}

	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return firstNode.data;
		}
	} 

	public T dequeue() {
		T front = getFront(); // Might throw EmptyQueueException
							// Assertion: firstNode != null
		firstNode.data = null;
		firstNode = firstNode.next;

		if (firstNode == null) {
			lastNode = null;
		}

		return front;
	} 

	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	} 

	public void clear() {
		firstNode = null;
		lastNode = null;
	} 

	public class Node {
		public T data; 
		public Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} 

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		}

		private T getData() {
			return data;
		} 

		private void setData(T newData) {
			data = newData;
		} 

		private Node getNextNode() {
			return next;
		} 

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	} 
} 
