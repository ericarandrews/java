import java.util.Arrays;

// note: this file does not appropriately use generics with Comparable;
// to avoid complicating sorting code with generics, I have used Comparable as a raw type and thus
// I am suppressing those warnings 
@SuppressWarnings({"rawtypes", "unchecked"})
public class SlowerSorts {

	
	// ******************************* SELECTION SORT

	public static void selectionSort(Comparable[] array) {
		for (int currentIndex = 0; currentIndex < array.length; currentIndex++) { 
			int minIndex = getIndexOfSmallest(array, currentIndex, array.length); 
			swap(array, currentIndex, minIndex);
		} 
	} 

	private static int getIndexOfSmallest(Comparable[] array, int firstPosition, int lastPosition) {
		Comparable min = array[firstPosition];
		int indexOfMin = firstPosition;
	
		for (int index = firstPosition + 1; index < lastPosition; index++) {
			if (array[index].compareTo(min) < 0) { // asks: is the current value smaller than min? if so, it's the new min
				min = array[index];
				indexOfMin = index;			
			} 
		} 
		return indexOfMin;
	} 
	
	private static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// ******************************* INSERTION SORT
	
	public static void insertionSort(Comparable[] array) {
	
		for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) { 
			Comparable unsortedElement = array[unsortedIndex];
			int lowestSortedIndex = 0;
			int highestSortedIndex = unsortedIndex-1;

			insertInOrder(unsortedElement, array, lowestSortedIndex, highestSortedIndex);
		} 
	}

	private static void insertInOrder(Comparable unsortedElement, Comparable[] array, int lowestSortedIndex, int highestSortedIndex) {
		int index = highestSortedIndex;
		while( index >= lowestSortedIndex &&
				unsortedElement.compareTo(array[index]) < 0 ) {
			array[index+1] = array[index]; // make room
			index--;
		}
		array[index+1] = unsortedElement; 
	}

	// ******************************* SHELL SORT

	public static void shellSort(Comparable[] array)  {
		int space = array.length/2;
		while(space > 0) {
	         if (space % 2 == 0) { // if space is even, add 1- efficiency improvement
	        	 space++;
	         }		
	         for (int begin = 0; begin < space; begin++) {
	            incrementalInsertionSort(array, begin, array.length-1, space);
	         }	      

	         space = space/2;
	   } 
	}
	   
	// compare this to insertionSort- it's the same algorithm when space==1!
	private static void incrementalInsertionSort(Comparable[] array, int first, int last, int space) {
	      
	      for (int unsortedIndex = first+space; unsortedIndex <= last; unsortedIndex = unsortedIndex+space) {

	    	 Comparable nextToInsert = array[unsortedIndex];
	         int index = unsortedIndex-space;
	         
	         while ((index >= first) && (nextToInsert.compareTo(array[index]) < 0)) {
	            array[index + space] = array[index];
	            index = index - space;
	         } 
	         
	         array[index + space] = nextToInsert;
	      } 
	   } 

} 