import java.util.*;

public class GuessingGame
{
	public static void main(String[] args)
	{
		NumberGuesser g = new NumberGuesser(1, 100);
		RandomNumberGuesser rng = new RandomNumberGuesser(1, 100);
		Random randomNumbers = new Random();
		
		char response;
		char randomNum;
	
		do {
			g.reset();
			System.out.println("Think of a number from 1 to 100.");
			
			do {
				response = promptUserAndGetResponse(rng.getCurrentGuess());
				
				if (response == 'h') rng.higher();
				if (response == 'l') rng.lower();
				if (response == 'r') rng.reset();
				
			} while (response != 'c');
			
		} while (shouldPlayAgain());
	}
	
	/**
	 * Helper Methods
	 */
	
	public static char promptUserAndGetResponse(int guess) {
		char response;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Is it " + guess + "? (h/l/c): ");
			response = input.next().charAt(0);
		} while (response != 'h' && response != 'l' && response != 'c' && response != 'r');
		
		return response;
	}
	  
	public static boolean shouldPlayAgain() {
		char response;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Do you want to play again? (y/n): ");
			response = input.next().charAt(0);
		} while (response != 'y' && response != 'n');
		
		return response == 'y';
	}
}