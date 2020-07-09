import java.util.*;

import javax.swing.JButton;

public class GenericsTester {
    
    private static final int ARRAY_SIZE = 100;

	public static void main(String[] args) {
		Integer[] numbers = new Integer[ARRAY_SIZE];
		fillArray(numbers);
		
		String[] words = new String[ARRAY_SIZE];
		fillArray(words);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(words));
		
		// FINDING DUPLICATES
		
		ArrayList<Integer> numberDups = ArrayUtilities.findDuplicateIntegers(numbers); 
		System.out.println("Number Duplicates: " + numberDups);
		numberDups = ArrayUtilities.findDuplicates(numbers); // uses type inference to figure out that Integer is the actual type!
        System.out.println("Number Duplicates: " + numberDups);
		
		ArrayList<String> wordDups = ArrayUtilities.findDuplicateStrings(words);
	    System.out.println("Word Duplicates: " + wordDups);
	    wordDups = ArrayUtilities.<String>findDuplicates(words); // explicitly defines the actual type
        System.out.println("Word Duplicates: " + wordDups);
	    
	    
	   
	    // FINDING MIN/MAX
		Pair<Integer> minMaxNumber = ArrayUtilities.<Integer>findMinMax(numbers);
	    System.out.println("The min is " + minMaxNumber.getFirst());
	    System.out.println("The max is " + minMaxNumber.getSecond());
	     
	    
        Pair<String> minMaxWord = ArrayUtilities.findMinMax(words);
        System.out.println("The min is " + minMaxWord.getFirst());
        System.out.println("The max is " + minMaxWord.getSecond());
		
        Student[] students = {null, null, null};
        //Pair<Student> minMaxStudent = ArrayUtilities.<Student>findMinMax(students); // COMPILER ERROR!
		

	}
	
	public static void fillArray(Integer[] numbers) {
		Random generator = new Random();
		int maxNum = 500;
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(maxNum);
		}
	}
	

    public static void fillArray(String[] words) {
        int wordLength = 3;
        Random random = new Random();
        for (int i = 0; i < words.length; i++) {
            char[] wordChar = new char[wordLength];
            for (int j = 0; j < wordChar.length; j++) {
                wordChar[j] = (char) (97 + random.nextInt(10)); 
                // Java characters have a corresponding int value; 'a' starts at 97
                // to ensure some duplicates, we're going to use only the first 10 letters
            }
            words[i] = String.valueOf(wordChar);
        }
    }
	    

	
}
