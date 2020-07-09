import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T>{
private T[] listArray;
private int numberOfElements;
private boolean integrityOK;
private static final int DEFAULT_CAPACITY = 10;
private static final int MAX_CAPACITY = 1000;

public ArrayHeadTailList(){
   this(DEFAULT_CAPACITY);
} 
//take an initial capacity in as a parameter
public ArrayHeadTailList(int initialCapacity){
   integrityOK = false;   
// Is initialCapacity too small?
   if (initialCapacity < DEFAULT_CAPACITY)
      initialCapacity = DEFAULT_CAPACITY;
   else // Is initialCapacity too big?
      checkCapacity(initialCapacity); 
// The cast is safe because the new array contains null entries
   @SuppressWarnings("unchecked")
   T[] tempList = (T[]) new Comparable[initialCapacity + 1];
   listArray = tempList;
// item = tempList;
   numberOfElements = 0;
   integrityOK = true;
}
//when the array is full, expand the array by doubling
@Override
public void addFront(T newEntry) { 
    add(numberOfElements + 1, newEntry);
    listArray[numberOfElements++ + 1] = listArray[numberOfElements--];
}
//when the array is full, expand the array by doubling
@Override
public void addBack(T newEntry) {
    add(numberOfElements + 1, newEntry);
}
//adds the element to the list of the array
public void add(int givenPosition, T newEntry){
   checkIntegrity();
   if ((givenPosition >= 1) && (givenPosition <= numberOfElements + 1)){
      if (givenPosition <= numberOfElements)
          for (int index = givenPosition; index < numberOfElements; index++)
              listArray[index] = listArray[index + 1];
      listArray[givenPosition] = newEntry;
      if(newEntry != null){numberOfElements++;}
      ensureCapacity(); // Ensure enough room for next add
   }else{throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");}
}
//the front integer of the array is removed
@Override
public T removeFront() {
	checkIntegrity();
	T result = listArray[numberOfElements];
	removeGap(1);
	numberOfElements--;
	return result;
}
//shifts entries that are beyond the entry to be removed to the next lower position.
//checkIntegrity has been called.
private void removeGap(int givenPosition){
	int removedIndex = givenPosition;
	for(int index = removedIndex; index < numberOfElements; index++){
		listArray[index] = listArray[index + 1];
	}
}
//throws an exception if the client requests a capacity that is too large.
private void checkCapacity(int capacity){
	if(capacity > MAX_CAPACITY){
		throw new IllegalStateException("Attempt to create a list" +
										"whose capacity exceeds " + 
										"allowed maximum.");}
}
//Doubles the capacity of the array list if it is full.
//Precondition: checkIntegrity has been called.
private void ensureCapacity(){
	int capacity = listArray.length - 1;
	if(numberOfElements >= capacity){
		int newCapacity = 2 * capacity;
		checkCapacity(newCapacity);// Is capacity too big?
		listArray = Arrays.copyOf(listArray, newCapacity + 1);}
}
//Throws an exception if this object is corrupt
private void checkIntegrity(){
	if(!integrityOK){throw new SecurityException("ArrayHeadTailList object is corrupt.");}
}
//removes the element in the back of the array 
@Override
public T removeBack() {
	checkIntegrity();
	T result = listArray[numberOfElements - 1];
	removeGap(numberOfElements - 1);
	listArray[numberOfElements] = null;
	numberOfElements--;
	return result;
}
//removes every element in the array
@Override
public void clear() {
	checkIntegrity();
    // Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfElements; index++) // Loop is part of Q4
			listArray[index] = null;

		numberOfElements = 0;
}
//review the interface to see what happens with invalid positions
@Override
public T getEntry(int givenPosition) {
	checkIntegrity();
    if (validPosition(givenPosition))
    {
       // Assertion: The list is not empty
       return listArray[givenPosition];
    }
    else
       throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");	
}
//validates a position
boolean validPosition(int position) {
		return position >= 1 && position <= numberOfElements;
	}
//see the tester program for the format of the output- your display must match this format!
//the output must contain the size, the capacity, and a display of all elements in the list
@Override
public void display() {
	if(numberOfElements < 1){System.out.println(numberOfElements + " elements; capacity = " + DEFAULT_CAPACITY);}
	else if(numberOfElements < 11){
		int i= 0;
		System.out.print(numberOfElements + " elements; capacity = " + DEFAULT_CAPACITY);
		System.out.print("\t[ ");
		for(i = 1; i < numberOfElements + 1; i++){System.out.print(listArray[i] + " ");}
		System.out.print("]");}
	else if(numberOfElements < 21){
		System.out.print(numberOfElements + " elements; capacity = " + DEFAULT_CAPACITY * 2);
		System.out.print("\t[ ");
		for(int i = 1; i < numberOfElements + 1; i++){System.out.print(listArray[i] + " ");}
		System.out.print("]");}
	else if(numberOfElements < 31){
		System.out.print(numberOfElements + " elements; capacity = " + DEFAULT_CAPACITY * 3);
		System.out.print("\t[ ");
		for(int i = 1; i < numberOfElements + 1; i++){System.out.print(listArray[i] + " ");}
		System.out.print("]");}
	else if(numberOfElements < 41){
		System.out.print(numberOfElements + " elements; capacity = " + DEFAULT_CAPACITY * 4);
		System.out.print("\t[ ");
		for(int i = 1; i < numberOfElements + 1; i++){System.out.print(listArray[i] + " ");}
		System.out.print("]");}
}
//returns the index of the element
@Override
public int indexOf(T anEntry) {
	checkIntegrity();
	int where = -1;
	boolean found = false;      
	int index = 0;
  
  while (!found && (index < numberOfElements)){
		if (anEntry.equals(listArray[index]))
		{
			found = true;
			where = index;
		}index++;
	}
	return where;
}
//returns the elements last index
@Override
public int lastIndexOf(T anEntry) {
	int where = -1;
	boolean found = false;      
	int index = 0;
  
  while (!found && (index < numberOfElements))
	{
		if (anEntry.equals(listArray[index]))
		{
			found = true;
			where = index;
		} 
     index++;
	}
	return where;
}
//returns whether the element is within the array
@Override
public boolean contains(T anEntry) {
	checkIntegrity();
    boolean found = false;
    int index = 1;
    while (!found && (index <= numberOfElements))
    {
       if (anEntry.equals(listArray[index]))
          found = true;
       index++;
    } // end while
    return found;	
}
//returns the size of the array
@Override
public int size() {
    return numberOfElements;
}
//returns whether the array is empty
@Override
public boolean isEmpty() {
	if(numberOfElements > 0){return false;}
	return true;
}
//end of ArrayHeadTailList
}
