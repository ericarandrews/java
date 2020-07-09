import java.util.Arrays;

/**
 * A class that implements a list of objects by using an array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AList<T extends Comparable<? super T>> implements ListInterface<T> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		this(DEFAULT_CAPACITY);
	} 

	public AList(int initialCapacity) {
		integrityOK = false;

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		} else { 
			checkCapacity(initialCapacity);
		}

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	} 

	public void add(T newEntry) {
		add(numberOfEntries + 1, newEntry);
	} 

	public void add(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
			if (givenPosition <= numberOfEntries) {
				makeRoom(givenPosition);
			}
			list[givenPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity(); // Ensure enough room for next add
		} else {
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
		}
	} 

	public T remove(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T result = list[givenPosition]; // Get entry to be removed

			// Move subsequent entries towards entry to be removed,
			// unless it is last in list
			if (givenPosition < numberOfEntries) {
				removeGap(givenPosition);
			}
			list[numberOfEntries] = null;
			numberOfEntries--;
			return result; 
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}
	} 

	
	public T getEntry(int givenPosition) {
		checkIntegrity();
		if (validPosition(givenPosition)) {
			// Assertion: The list is not empty
			return list[givenPosition];
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		}
	} 
	
	public T replace(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		}
	}

/*
	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} 
		return found;
	} 
*/
	public boolean contains(T anEntry) {
		if(isEmpty()) { // account for an empty list either here or in the helper method
			return false;
		} else {
			return containsHelper(anEntry, 1, numberOfEntries);
		}
	}
	private boolean containsHelper(T anEntry, int start, int end) {
		if(start == end) { // base case- the recursion is done
			if(list[start].equals(anEntry)) {
				return true;
			} else {
				return false;
			}
		} else { // recursive case- start < end
			T currentEntry = list[start];
			if(currentEntry.equals(anEntry)) {
				return true;
			} else {
				return containsHelper(anEntry, start+1, end);
			}
			
		}
	}
	public void clear() {
		checkIntegrity();

		// Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfEntries; index++) {
			list[index] = null;
		}

		numberOfEntries = 0;
	} 
	
	public int getLength() {
		return numberOfEntries;
	} 

	public boolean isEmpty() {
		return numberOfEntries == 0; // Or getLength() == 0
	} 
	
	public T[] toArray() {
		checkIntegrity();

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}

		return result;
	}


	// Doubles the capacity of the array list if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} 
	} 

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	// numberOfEntries is list's length before addition;
	// checkIntegrity has been called.
	private void makeRoom(int givenPosition) {
		// Assertion: (newPosition >= 1) && (newPosition <= numberOfEntries + 1)
		int newIndex = givenPosition;
		int lastIndex = numberOfEntries;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--) {
			list[index + 1] = list[index];
		}
	}
	
	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	// numberOfEntries is list's length before removal;
	// checkIntegrity has been called.
	private void removeGap(int givenPosition) {
		int removedIndex = givenPosition;
		for (int index = removedIndex; index < numberOfEntries; index++)
			list[index] = list[index + 1];
	} 

	// Throws an exception if this object is corrupt.
	private void checkIntegrity() {
		if (!integrityOK) {
			throw new SecurityException("AList object is corrupt.");
		}
	} 

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException(
					"Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
		}
	} 

	public boolean moveToEnd() {
		if (numberOfEntries == 1) { // no changes made for a singleton list
			return true;
		} else if (!isEmpty()) { // changes made for lists larger than size 1
			T firstItem = remove(1);
			add(firstItem);
			return true;
		} else { // empty list
			return false;
		}
	}

	private boolean validPosition(int position) {
		return position >= 1 && position <= numberOfEntries;
	}

	public void swap(int firstPosition, int secondPosition) {
		if (validPosition(firstPosition) && validPosition(secondPosition)) {
			T temp = list[firstPosition];
			list[firstPosition] = list[secondPosition];
			list[secondPosition] = temp;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to swap operation.");
		}
	}

	public ListInterface<T> getAllLessThan(T entry) {
		AList<T> lessThanList = new AList<>();
		for (int i = 1; i <= numberOfEntries; i++) {
			T currentItemOnList = list[i];
			if (currentItemOnList.compareTo(entry) < 0) { // currentItemOnList is SMALLER THAN entry
				lessThanList.add(currentItemOnList);
			}
		}
		return lessThanList;
	}

	
} 
