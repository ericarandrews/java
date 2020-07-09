
public class Searches {

	// finds the first location of a target
	public static int linearSearchIterative(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false; // include if we want to stop when we find the target
		// without this variable, we will return the LAST location of the target

		int comparisonCount = 0;

		for (int i = 0; (i < numbers.length && !found); i++) {
			comparisonCount++;
			if (numbers[i] == target) {
				found = true;
				targetLocation = i;
			}
		}
		System.out.println("In linear search iterative, comparison count is \t" + comparisonCount);
		return targetLocation;

	}

	public static int linearSearchRecursive(int[] numbers, int target) {
		comparisonCountLinearRecursive = 0;
		int answer = linearSearchRecursiveHelper(numbers, target, 0, numbers.length - 1);
		System.out.println("In linear search recursive, comparison count is \t" + comparisonCountLinearRecursive);
		return answer;
	}

	private static int comparisonCountLinearRecursive = 0;
	
	private static int linearSearchRecursiveHelper(int[] numbers, int target, int first, int last) {
		comparisonCountLinearRecursive++;
		if (first > last) { // indices cross over- it's not here
			return -1;
		} else if (target == numbers[first]) { // we found it!
			return first; 
		} else { // keep looking
			return linearSearchRecursiveHelper(numbers, target, first + 1, last);
			
		}
	}

	public static int linearSearchIterativeImprovedForSorted(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false;
		boolean gonePastTarget = false;
		int comparisonCount = 0;

		for (int i = 0; (i < numbers.length && !found && !gonePastTarget); i++) {
			comparisonCount++;
			if (numbers[i] == target) {
				found = true;
				targetLocation = i;
			} else if (numbers[i] > target) {
				gonePastTarget = true;
			}
		}
		System.out.println("In linear search optimized for sorting, count is \t" + comparisonCount);
		return targetLocation;
	}

	public static int binarySearchIterative(int[] numbers, int target) {
		int targetLocation = -1;
		boolean found = false;
		int first = 0;
		int last = numbers.length - 1;
		int comparisonCount = 0;

		while (first <= last && !found) {
			comparisonCount++;
			int mid = (first + last) / 2;

			if (numbers[mid] == target) {
				targetLocation = mid;
				found = true;
			} else if (numbers[mid] < target) {
				first = mid + 1;
			} else { // numbers[mid] > target
				last = mid - 1;
			}
		}
		System.out.println("In binary search iterative, comparison count is \t" + comparisonCount);
		return targetLocation;
	}

	public static int binarySearchRecursive(int[] numbers, int target) {
		comparisonCountBinaryRecursive = 0;
		int answer = binarySearchRecursiveHelper(numbers, target, 0, numbers.length - 1);
		System.out.println("In binary search recursive, comparison count is \t" + comparisonCountBinaryRecursive);
		return answer;
	}

	private static int comparisonCountBinaryRecursive = 0;

	private static int binarySearchRecursiveHelper(int[] numbers, int target, int first, int last) {
		int mid = ((last - first) / 2) + first;
		comparisonCountBinaryRecursive++;
		if (first > last) {
			return -1; // indices cross over
		} else if (target == numbers[mid]) {
			return mid; // we found it!
		} else if (target < numbers[mid]) {
			return binarySearchRecursiveHelper(numbers, target, first, mid - 1);
			// keep looking in left half
		} else { // target > numbers[mid]
			return binarySearchRecursiveHelper(numbers, target, mid + 1, last);
			// keep looking in right half
		}
	}

}
