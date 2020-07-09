/**
 * A class that implements the ADT queue by using a two-part circular chain of
 * linked nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {
	private Node queueNode; // References first node in queue
	private Node freeNode; // References node after back of queue

	public TwoPartCircularLinkedQueue() {
		freeNode = new Node(null, null);
		freeNode.next = freeNode;
		queueNode = freeNode;
	} 

	public void enqueue(T newEntry) {
		freeNode.data = newEntry;

		if (isNewNodeNeeded()) {
			// Allocate a new node and insert it after the freeNode
			Node newNode = new Node(null, freeNode.next);
			freeNode.next = newNode;
		} 

		freeNode = freeNode.next;
	} 

	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return queueNode.data;
		}
	} 

	public T dequeue() {
		T front = getFront(); // Might throw EmptyQueueException
								// Assertion: Queue is not empty
		queueNode.data = null;
		queueNode = queueNode.next;

		return front;
	} 

	public boolean isEmpty() {
		return queueNode == freeNode;
	} 

	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
	} 

	private boolean isNewNodeNeeded() {
		return queueNode == freeNode.next;
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

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end TwoPartCircularLinkedQueue
