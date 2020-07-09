import java.util.*; 

public class ValuedRecursionExamples {

	public static void main(String[] args) {
		System.out.println(sumToOneWithReturn(10));
		System.out.println(sumToOneWithLocalVariables(10));
		
//		int userNumber = readUserInput(1,10);
//		System.out.println("You entered: " + userNumber);
		
		System.out.println(countCharacters("mississippi", 'i'));
		
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(sumArray(numbers));

	}

	public static int sumToOneWithReturn(int number) {
		if(number==1) { // base case
			return 1; // the base case value is also returned
		} else { // recursive case
			return number + sumToOneWithReturn(number-1); // the recursive call is returned
			// we combine the small part with the recursive part AND we return that value
		}
	}
	public static int sumToOneWithLocalVariables(int number) {
		int sum = 0; // local variable
		if(number==1) {
			sum = 1;
		} else { // recursive case
			sum = number + sumToOneWithLocalVariables(number-1); // combine the small part of the solution with the recursive part AND 
			// store it in a local variable
		}
		return sum;
	}
	
	public static int readUserInput(int lower, int upper) {
		System.out.println("Enter a number between " + lower + " and " + upper);
		Scanner scan = new Scanner(System.in);
		int userNumber = Integer.parseInt(scan.nextLine());
		if(userNumber < lower || userNumber > upper) { // recursive case 
			System.out.println("Input out of range. Try again.");
			userNumber = readUserInput(lower, upper); // recursive calls are linked together by storing the result in a local variable
		}
		// implicit base case
		
		return userNumber;
	}
	
	public static int countCharacters(String word, char character) {
		// return countCharactersHelperLocalVariables(word, character, 0);
		return countCharactersHelperMultipleReturns(word, character, 0);
		
	}
	private static int countCharactersHelperLocalVariables(String word, char character, int index) {
		int count = 0;
		if(index < word.length()) { // recursive case
			if(word.charAt(index)==character) { // solving small part now
				count = 1;
			}
			count = count + countCharactersHelperLocalVariables(word, character, index+1); // recursive call
			// COMBINE the small part of the solution to the recursive "solve later" part
			// STORE THEM ALL in a local variable
			// could also write as: count += countCharacters...
		}
		// implicit base case
		return count;
	}
	private static int countCharactersHelperMultipleReturns(String word, char character, int index) {
		if(index < word.length()) { // recursive case
			if(word.charAt(index)==character) {
				return 1 + countCharactersHelperMultipleReturns(word, character, index+1);
				// combining the small part of the solution with the recursive part AND returning that combined solution
			} else {
				return 0 + countCharactersHelperMultipleReturns(word, character, index+1);
			}
		} else { // base case
			return 0;
		}
		
	}
	

	public static int sumArray(int[] array) {
		//return sumArrayHelperWithReturns(array, 0);
		return sumArrayHelperWithLocalVariables(array, 0);
	}
	private static int sumArrayHelperWithReturns(int[] array, int index) {
		if(index < array.length) { // recursive case
			return array[index] + sumArrayHelperWithReturns(array, index+1);
		} else { // base case
			return 0;
		}
	}
	private static int sumArrayHelperWithLocalVariables(int[] array, int index) {
		int sum = 0;
		if(index < array.length) { // recursive case
			sum = array[index] + sumArrayHelperWithLocalVariables(array, index+1);
			// combining the small part of the solution with the recursive rest of the solution and
			// putting into a local variable
		}
		// implicit base case
		
		return sum;
	}
	
	
	
	
	
	
	
	
	
}
