import java.util.EmptyStackException;

public class ArrayReverseStack<T> implements StackInterface<T> {

	private T[] stack;
	private int topIndex;

	public final static int DEFAULT_INITIAL_CAPACITY = 5;

	public ArrayReverseStack() {
		T[] tempStack = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
		stack = tempStack;
		topIndex = stack.length;
	}

	public void push(T newEntry) {
		if(topIndex == 0) {
			doubleCapacity();
		} 
		topIndex--;
		stack[topIndex] = newEntry;
	}

	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex++;
			return top;
		}
	}

	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			return stack[topIndex];
		}
	}

	public boolean isEmpty() {
		return topIndex >= stack.length;
	}

	public void clear() {
		for(int i=topIndex; i<stack.length; i++) {
			stack[i] = null;
		}
		topIndex = stack.length;
	}
	
	private void doubleCapacity() {
		int oldSize = stack.length;
		int newSize = oldSize * 2;
		T[] tempArray = (T[]) new Object[newSize];
		for(int i=0; i<stack.length; i++) {
			tempArray[oldSize+i] = stack[i];
		}
		stack = tempArray;
		topIndex = oldSize;
	}
	
	
}
