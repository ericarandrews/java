import java.util.Arrays;

//note: this file does not appropriately use generics with Comparable;
//to avoid complicating sorting code with generics, I have used Comparable as a raw type and thus
//I am suppressing those warnings 
@SuppressWarnings({"rawtypes", "unchecked"})
public class FasterSorts {

	// ******************************* MERGE SORT
	
	public static void mergeSort(Comparable[] array) {
		Comparable[] tempArray = new Comparable[array.length];
		mergeSortHelper(array, tempArray, 0, array.length-1);
	} 

	private static void mergeSortHelper(Comparable[] array, Comparable[] tempArray, int first, int last) {	
		if (first < last) { 
			int mid = (first+last) / 2;
			mergeSortHelper(array, tempArray, first, mid); // the divide/splitting steps
			mergeSortHelper(array, tempArray, mid+1, last); 

			if (array[mid].compareTo(array[mid+1]) > 0) { // efficiency improvement- when this fails, there is no need to merge
				merge(array, tempArray, first, mid, last); // merging together of the solutions
			} 
		} 
	} 

	private static void merge(Comparable[] array, Comparable[] tempArray, int first, int mid, int last) {

		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid+1;
		int endHalf2 = last;

		int index = beginHalf1; 
		
		// there are more elements still in both lists
		while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2) ) { 
			if (array[beginHalf1].compareTo(array[beginHalf2]) < 0) {
				tempArray[index] = array[beginHalf1];
				beginHalf1++;
			} else {
				tempArray[index] = array[beginHalf2];
				beginHalf2++;
			}
			index++;
		} 


		// elements remaining in left half
		while (beginHalf1 <= endHalf1) {
			tempArray[index] = array[beginHalf1];
			beginHalf1++;
			index++;
		}

		// elements remaining in right half
		while(beginHalf2 <= endHalf2) {
			tempArray[index] = array[beginHalf2];
			beginHalf2++;
			index++;
		}

		// copy the result back into the original array
		for (index = first; index <= last; index++) {
			array[index] = tempArray[index];
		}
		
	}

	// ******************************* QUICK SORT
	
	public static final int MIN_SIZE = 5; // for quick sort
	
	public static void quickSort(Comparable[] array) {
		quickSort(array, 0, array.length-1);
	}

	private static void quickSort(Comparable[] array, int first, int last) {
		if (last - first + 1 < MIN_SIZE) {
			insertionSort(array, first, last+1); 
		} else {
			// create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(array, first, last);

			// sort subarrays Smaller and Larger
			quickSort(array, first, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, last);
		} 
	} 

	private static int partition(Comparable[] array, int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMiddleLast(array, first, mid, last);
		
		swap(array, mid, last - 1);
		int pivotIndex = last - 1;

		Comparable pivot = array[pivotIndex];

		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		boolean done = false;
		while (!done) {
			
			while (array[indexFromLeft].compareTo(pivot) < 0) {
				indexFromLeft++;
			}

			while (array[indexFromRight].compareTo(pivot) > 0) {
				indexFromRight--;
			}

			assert array[indexFromLeft].compareTo(pivot) >= 0
					&& array[indexFromRight].compareTo(pivot) <= 0;

			if (indexFromLeft < indexFromRight) {
				swap(array, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
				
			} else {
				done = true;
			}
		} 

		swap(array, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;

		return pivotIndex;
	} 

	private static void sortFirstMiddleLast(Comparable[] array, int first, int mid, int last) {
		if (array[first].compareTo(array[mid]) > 0) {
			swap(array, first, mid);
		}
		if (array[mid].compareTo(array[last]) > 0) {
			swap(array, mid, last);
		}
		if (array[first].compareTo(array[mid]) > 0) {
			swap(array, first, mid);
		}
	}
	
	private static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void insertionSort(Comparable[] array, int first, int last) {
		
		for (int unsortedIndex = first+1; unsortedIndex < last; unsortedIndex++) { 
			Comparable unsortedElement = array[unsortedIndex];
			int lowestSortedIndex = 0;
			int highestSortedIndex = unsortedIndex-1;
			int index = highestSortedIndex;

			while( index >= lowestSortedIndex &&
					unsortedElement.compareTo(array[index]) < 0 ) {
				array[index+1] = array[index]; // make room
				index--;
			}
			array[index+1] = unsortedElement; 
		} 
	}



} 