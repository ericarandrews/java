import java.util.Arrays;
import java.util.Random;

public class SortTester {

	
	public static void main(String[] args) {

		Random generator = new Random();
		Integer[] numbers = new Integer[1000];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(100);
		}
		System.out.println(Arrays.toString(numbers));
		SlowerSorts.selectionSort(numbers);
		//SlowerSorts.insertionSort(numbers);
		//SlowerSorts.shellSort(numbers);
		//FasterSorts.mergeSort(numbers);
		//FasterSorts.quickSort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		Student s1 = new Student("Jane Jones", "C123");
		Student s2 = new Student("Sam Smith", "A654");
		Student s3 = new Student("Al Adams", "Q777");
		Student s4 = new Student("Ray Rogers", "B519");
		Student[] students = {s1, s2, s3, s4};
		System.out.println(Arrays.toString(students));
		SlowerSorts.selectionSort(students);
		//SlowerSorts.insertionSort(students);
		//SlowerSorts.shellSort(students);
		//FasterSorts.mergeSort(students);
		//FasterSorts.quickSort(students);
		System.out.println(Arrays.toString(students));
		
	}
	


	

}






