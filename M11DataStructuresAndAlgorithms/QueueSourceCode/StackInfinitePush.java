
public class StackInfinitePush<T> implements StackInterface<T> {
	
	private DequeInterface<T> deque; // front of the deque is the top of my stack
	private int capacity;
	private int currentSize;
	
	public StackInfinitePush(int capacity) {
		deque = new ArrayDeque<>(); // or new LinkedDeque<>();
		this.capacity = capacity;
		this.currentSize = 0;
	}

	public void push(T newEntry) {
		if(currentSize<capacity) {
			deque.addToFront(newEntry);
			currentSize++;
		} else {
			deque.removeBack();
			deque.addToFront(newEntry);
		}
	}

	public T pop() {
		T top = null;
		
		if(!isEmpty()) {
			top = deque.removeFront();
			currentSize--;
		}
		
		return top;
	}

	public T peek() {
		return deque.getFront();
	}
	
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	
	public void clear() {
		deque.clear();
		currentSize = 0;
	}

	
	
}
