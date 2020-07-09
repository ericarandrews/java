import java.util.*;

public class VoidRecursionExamples {

	public static void main(String[] args) {
		printCharacters("Hello!");
		printCharactersEfficient("Hello!");
		
		int[] numbers = {1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(numbers));
		doubleArray(numbers);
		System.out.println(Arrays.toString(numbers));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		doubleList(list);
		System.out.println(list);

	}
	
	public static void printCharacters(String word) {
		/*
		if(word.length()==1) { // base case
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now	
		} else { // recursive case 
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now	
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		*/			
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
		if(word.length()>1) { // recursive case
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		// implicit base case- not explicitly listed
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
	}
	
	public static void printCharactersEfficient(String word) {
		printCharactersEfficientHelper(word, 0);
	}
	private static void printCharactersEfficientHelper(String word, int index) {
		System.out.println(word.charAt(index));
		if(index < word.length()-1 ) { // recursive call
			printCharactersEfficientHelper(word, index+1);
		}
	}
	
	public static void doubleArray(int[] array) {
		doubleArrayHelper(array, 0);
	}
	private static void doubleArrayHelper(int[] array, int index) {
		if(index<array.length) { // recursive call
			array[index] = array[index] * 2; // small part we're solving now
			doubleArrayHelper(array, index+1); // recursive call
		}
		// implicit base case
	}
	
	public static void doubleList(List<Integer> list) {
		doubleListHelper(list, 0);
	}
	private static void doubleListHelper(List<Integer> list, int index) {
		if(index<list.size()) { // recursive case
			int value = list.get(index);
			list.set(index, value*2);
			doubleListHelper(list, index+1);
		}
		// implicit base case
	}
	
	
	
	
	
	
	
	
	
	
	

}
