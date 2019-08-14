import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class NumberGuesserDemo {
	
	public static void main(String[]args)
	{
	
		NumberGuesserClass ng = new NumberGuesserClass(1,10);
		Scanner input = new Scanner(System.in);	

		System.out.println(ng.getCurrentGuess());
		System.out.println(ng.getCurrentGuess());
		System.out.println(ng.getCurrentGuess());
		System.out.println(ng.getCurrentGuess());
		
		RandomNumberGuesserClass rng = new RandomNumberGuesserClass(1,10);
		System.out.println(rng.getCurrentGuess());
	
	}
}
