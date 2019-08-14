import java.util.Scanner;

public class StringProcessorProgram {

	public static void main(String[]args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a line of text: ");
		
		//String s holds string input
		String s = keyboard.nextLine();
		StringProcessor p = new StringProcessor(s);
		
			//Outputs how many words are in string 
			System.out.println("\nwords: " + p.wordCount());
			//Outputs how many word are in string with Upper Case letters
			System.out.println("upperCase: " + p.uppercaseCount());
			//Outputs how many digits are in string 
			System.out.println("digits: " + p.digitCount());
			//Outputs how many words equal to numbers 0-9 displayed in English wording
			System.out.println("digit words: " + p.digitWordCount());
			//Outputs string with whitespace removed
			System.out.println("line with whitespace removed: " + p.getNoSpaceString());
			//Outputs string with vowels removed and replaced with dash character ("-")
			System.out.println("line with vowels replaced: " + p.getNoVowelString());
			//Outputs string with all digits in English wording replaced by digit characters
			System.out.println("line with digit words replaced: " + p.getNoDigitWordString());
	}	
}
