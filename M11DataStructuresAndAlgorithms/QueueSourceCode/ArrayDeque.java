
public class ArrayDeque<T> implements DequeInterface<T> {

	public T[] deque; // circular array of queue entries and one unused location
	private int frontIndex;
	private int backIndex;

	private static final int DEFAULT_INITIAL_CAPACITY = 50;

	public ArrayDeque() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ArrayDeque(int initialCapacity) {
		deque = (T[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	}

	public void addToBack(T newEntry) { // same as ArrayQueue enqueue
		ensureCapacity();
		backIndex = (backIndex + 1) % deque.length;
		deque[backIndex] = newEntry;
	}

	public void addToFront(T newEntry) {
		ensureCapacity();
		frontIndex = (frontIndex - 1 + deque.length) % deque.length;
		deque[frontIndex] = newEntry;
	}

	public T getFront() { // same as ArrayQueue
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return deque[frontIndex];
		}
	}

	public T getBack() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return deque[backIndex];
		}

	}

	public T removeFront() { // same as ArrayQueue dequeue
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			T front = deque[frontIndex];
			deque[frontIndex] = null;
			frontIndex = (frontIndex + 1) % deque.length;
			return front;
		}
	}

	public T removeBack() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			T back = deque[backIndex];
			deque[backIndex] = null;
			backIndex = (backIndex - 1 + deque.length) % deque.length;
			return back;
		}
		
	}

	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % deque.length);
	}

	public void clear() {  // same as ArrayQueue dequeue
		if (!isEmpty()) {
			for (int index = frontIndex; index != backIndex; index = (index + 1) % deque.length) {
				deque[index] = null;
			}
			deque[backIndex] = null;
		}
		frontIndex = 0;
		backIndex = deque.length - 1;
	}



	
	// Doubles the size of the array queue if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {  // same as ArrayQueue dequeue
		if (frontIndex == ((backIndex + 2) % deque.length)) { 
			// If array is full, double size of array
			T[] oldDeque = deque;
			int oldSize = oldDeque.length;
			int newSize = 2 * oldSize;

			// The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempDeque = (T[]) new Object[newSize];
			deque = tempDeque;
			for (int index = 0; index < oldSize - 1; index++) {
				deque[index] = oldDeque[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} 

			frontIndex = 0;
			backIndex = oldSize - 2;
		} 
	}

}
