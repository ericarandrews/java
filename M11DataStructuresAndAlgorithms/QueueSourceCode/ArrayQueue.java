/**
 * A class that implements the ADT queue by using an expandable circular array
 * with one unused location after the back of the queue.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class ArrayQueue<T> implements QueueInterface<T> {
	
	public T[] queue; // Circular array of queue entries and one unused location
	private int frontIndex; // Index of front entry
	private int backIndex; // Index of back entry
	private static final int DEFAULT_CAPACITY = 3;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	} 

	public ArrayQueue(int initialCapacity) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
	} 

	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	} 

	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return queue[frontIndex];
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	} 

	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	}

	public void clear() {
		if (!isEmpty()) {
			for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length) {
				queue[index] = null;
			} 

			queue[backIndex] = null;
		} 

		frontIndex = 0;
		backIndex = queue.length - 1;
	} 

	
	// Doubles the size of the array queue if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % queue.length)) { 
			// If array is full, double size of array
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;

			// The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} 

			frontIndex = 0;
			backIndex = oldSize - 2;
		} 
	} 

} 
