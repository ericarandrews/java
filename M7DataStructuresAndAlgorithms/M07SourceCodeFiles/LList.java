/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class LList<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node firstNode; 
	private int numberOfEntries;

	public LList() {
		initializeDataFields();
	} 

	public void add(T newEntry) { 	
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			firstNode = newNode;
		} else { 
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode); // equivalent to lastNode.next = newNode;
		} 

		numberOfEntries++;
	} 

	public void add(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
			
			Node newNode = new Node(newEntry);
			
			if (givenPosition == 1) { // Case 1: adding first in the chain; also works for an empty list
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else { // Case 2: givenPosition > 1 (and list is not empty)
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeAfter = nodeBefore.next; 
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} 
			numberOfEntries++;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		}
	} 

	public T remove(int givenPosition) {
		T result = null; 

		if (validPosition(givenPosition)) {
			// Assertion: !isEmpty()
			
			if (givenPosition == 1) { // Case 1: Remove first entry
				result = firstNode.data; 
				firstNode = firstNode.next; 
			} else { // Case 2: Not first entry
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.next;
				result = nodeToRemove.data; 
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.setNextNode(nodeAfter); // Remove entry
			} 
			numberOfEntries--;
			return result; 
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}
	} 

	public T replace(int givenPosition, T newEntry) {
		if (validPosition(givenPosition)) {
			// Assertion: !isEmpty()
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.data;
			desiredNode.data = newEntry;
			return originalEntry;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		}
	} 

	public T getEntry(int givenPosition) {
		if (validPosition(givenPosition)) {
			// Assertion: !isEmpty()
			return getNodeAt(givenPosition).data;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		}
	} 

	/*
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				found = true;
			} else {
				currentNode = currentNode.next;
			}
		} 
		return found;
	} 
	*/
	
	public boolean contains(T anEntry) {
		return containsHelper(firstNode, anEntry);
	}
	private boolean containsHelper(Node currentNode, T anEntry) {
		if(currentNode == null) { // base case
			return false;
		} else { // recursive case
			T currentData = currentNode.data;
			if(currentData.equals(anEntry)) {
				return true;
			} else {
				return containsHelper(currentNode.next, anEntry);
			}
			
		}
	}
	public void clear() {
		initializeDataFields();
	} 

	public int getLength() {
		return numberOfEntries;
	} 

	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) { // Or getLength() == 0
			// Assertion: firstNode == null
			result = true;
		} else {
			// Assertion: firstNode != null
			result = false;
		} 
		return result;
		
	} 

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // changed from Object[]

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			currentNode = currentNode.next;
			index++;
		} 

		return result;
	} 
	
	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	} 

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) &&
		// (1 <= givenPosition) && (givenPosition <= numberOfEntries)
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node 
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	} 

	private boolean validPosition(int position) {
		return position >= 1 && position <= numberOfEntries;
	}

	public void swap(int firstPosition, int secondPosition) {
		if(validPosition(firstPosition) && validPosition(secondPosition)) { 
			Node firstNode = getNodeAt(firstPosition);
			Node secondNode = getNodeAt(secondPosition);
			
			T temp = firstNode.data;
			firstNode.data = secondNode.data;
			secondNode.data = temp;
			
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to swap operation.");
		}
		
	}
	

	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof LList<?>) {
			LList<T> otherList = (LList<T>) obj;
			
			if(numberOfEntries==otherList.numberOfEntries) {
				
				Node currentThis = this.firstNode;
				Node currentThat = otherList.firstNode;
				
				while(currentThis != null && currentThat != null) {
					T thisElement = currentThis.data;
					T thatElement = currentThat.data;
					if(!thisElement.equals(thatElement)) {
						return false; // found mismatched element
					} else {
						currentThis = currentThis.next;
						currentThat = currentThat.next;
					}
				}
				return true;
				
				// this will work! but it is WILDLY inefficient!
				/*
				for(int i=1; i<=numberOfEntries; i++) {
					T thisElement = this.getEntry(i);
					T otherElement = otherList.getEntry(i);
					if(!thisElement.equals(otherElement)) {
						return false; // found a mismatched element
					}
				}
				return true;
				*/
	
				
			} else {
				return false; // lists are not the same size
			}
		} else {
			return false; 
		}
	}
	
	public LList<T> getAllLessThan(T target) {
		LList<T> lessThanList = new LList<T>();
		// Node currentLessThan = lessThanList.firstNode;
		
		Node current = firstNode;
		
		while(current!=null) {
			T currentData = current.data;
			if(currentData.compareTo(target) < 0) {
				lessThanList.add(currentData); // works! but it's inefficient! how can we fix it?!
			}
		}
		return lessThanList;
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
	} // end Node
} 
