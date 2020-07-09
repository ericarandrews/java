public class LinkedHeadTailList<T> implements HeadTailListInterface<T> {

	private Node head, tail;
   
    T head;
	T tail;
	private int numberOfEntries;
	private T[] tempStack;
	private T[] stack; 
	private int topIndex;
	private int count = 100000;

	  public void addFront(T newEntry) {
		tempStack = (T[]) new Object[count];
		stack = tempStack;topIndex = stack.length;
		head = newEntry;
		if(numberOfEntries < 1){tail = head;}
		topIndex--;stack[topIndex] = newEntry;
		numberOfEntries++;
		}
	  public void addBack(T newEntry) {
			tail = newEntry;
			numberOfEntries++;
		}
	  public T removeFront() {
			head = null;
			return head;
		}
	  public T removeBack() {
			tail = null;
			return tail;
		}
	  public void clear() {
			numberOfEntries = 0;
		}
	  public T getEntry(int givenPosition) {
			T element = null;
			while(topIndex != 0){
			if(stack[givenPosition] == stack[topIndex]){
				element = stack[topIndex];
			}topIndex--;
			}
			return element;
		}
	  public void display() {
			if(numberOfEntries == 0){
				System.out.print("My results:");
				System.out.println("[]");
			}
			if(numberOfEntries > 0){
			System.out.print("["+stack[topIndex]+"]");
				topIndex--;
			System.out.print("");
			System.out.print("\thead="+head+" tail="+tail+"\n");
			}
			
		}
	  public int indexOf(T anEntry) {
			int index = 0;
			while(topIndex != 0){
			topIndex = topIndex+1;
			if(anEntry == stack[topIndex]){
				index = topIndex;
			}topIndex--;
			}
			return index;
		}
	  public int lastIndexOf(T anEntry) {
			int lastElement = 0;
			while(topIndex != 0){
			if(anEntry == stack[topIndex]){
				lastElement = topIndex;
				if(stack[topIndex] != stack[topIndex--]){
					return lastElement;
				}
			}topIndex--;
			}
			return lastElement;
		}
	   public boolean contains(T anEntry) {
			T element = null;
			while(topIndex != 0){
			if(anEntry == stack[topIndex]){
				return true;
			}topIndex--;
			}
			return false;
		}
	   public int size() {
			return numberOfEntries;
		}
	   public boolean isEmpty() {
			if(numberOfEntries==0){
				return true;
			}
			return false;
		} 	
	private class Node {
		private T data; 
		private Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
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
