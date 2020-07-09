import java.util.*;
import java.time.*;

public class EfficiencyExamples {

	public static void main(String[] args) {
		int listSize = 10;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		fillList(numberList, listSize);
		System.out.println(numberList);

		Instant start = Instant.now();
		System.out.println("What's the middle value? " + getMiddleValue(numberList));
		Instant end = Instant.now();
		Duration timeSpent = Duration.between(start, end);
		System.out.println("Constant algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");	

		start = Instant.now();
		System.out.println("What's the sum? " + calculateSum(numberList));
		end = Instant.now();
		timeSpent = Duration.between(start, end);
		System.out.println("Linear algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");
		
		start = Instant.now();
		System.out.println("Contains a duplicate? " + containsDuplicates(numberList));
		end = Instant.now();
		timeSpent = Duration.between(start, end);
		System.out.println("Quadratic algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");

	}
	
	// constant time method O(1)
	// this code/method is not dependent on the size of the list
	public static int getMiddleValue(ArrayList<Integer> numberList) {
		int middleIndex = numberList.size()/2; // size method is also constant
		return numberList.get(middleIndex); // get method is constant time- per the ArrayList API description
	}

	// linear time method O(n)
	// the method IS dependent on the size of the list
	// as the list increases, the time to execute also increases *AT THE SAME RATE*
	// for example: double the size of the list, we double the time it takes to execute the method
	public static int calculateSum(ArrayList<Integer> numberList) {
		int sum = 0;
		for(int i=0; i<numberList.size(); i++) { // loop is dependent on the size of the list
			sum += numberList.get(i); // get method is constant O(1)
		}
		return sum;
	}
	
	// quadratic method O(n^2)
	// as the size our data set increases, the running time increases *AT A FASTER RATE*
	// (outer loop n) * (inner loop n) = n^2
	// for example, if we double the size of our data (data x2), the running time might increase by a factor of 4 (time increase by 2^ or 2x2 = 4)
	// note: this method can be made more efficient from a real-world perspective (although it will still be O(n^2))
	public static boolean containsDuplicates(ArrayList<Integer> numberList) {
		boolean duplicates = false;
		for(int i=0; i<numberList.size(); i++) { // loop is dependent on n
			int currentNumber = numberList.get(i); // get is O(1)
			
			for(int j=0; j<numberList.size(); j++) { // loop is dependent on n- but this is a nested loop!!
				int compareNumber = numberList.get(j); // get is O(1)
				if(currentNumber==compareNumber && i!=j) {
					duplicates = true;
				}
			}
		}
		return duplicates;
	}

	private static void fillList(List<Integer> numberList, int size) {
		Random generator = new Random();
		int minNumber = 0;
		int maxNumber = size*2;
		for(int i=0; i<size; i++) {
			numberList.add(generator.nextInt(maxNumber - minNumber + 1) + minNumber);
		}
	}
}
