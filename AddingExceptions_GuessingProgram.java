import java.util.Scanner;

public class AddingExceptions_GuessingProgram
{
	public static void main(String[] args)
	{
		int lowerBound = 1;
		int upperBound = 100;
		
		int modules_one = 0;
		int modules_two = 0;

		AddingExceptions_NumberGuesser guesser = new AddingExceptions_NumberGuesser(lowerBound, upperBound);
		char response;
	
		do {
			guesser.reset();
			System.out.println("\nThink of a number from " + lowerBound + " to " + upperBound + ".");
		
			do {
				
				modules_one = guesser.getCurrentGuess();				
				response = promptUserAndGetResponse(guesser.getCurrentGuess());				
				
				try
				{
					if(modules_one == modules_two)
					{
						throw new IllegalStateException();
					}
					if(guesser.getCurrentGuess() < lowerBound)
					{
						throw new IllegalStateException();
					}
					if(guesser.getCurrentGuess() > upperBound)
					{
						throw new IllegalStateException();
					}
				}
				catch(IllegalStateException e)
				{
					System.out.println("\nYou have been caught cheating!\n" +
							"Your number has been guessed.");
					if(response == 'y')
					{	
						response = 'r';
					}
					else
					{
						break;
					}
				}
				
						
				if (response == 'h') 
				{
					modules_two = guesser.getCurrentGuess();
					guesser.higher();
				}
				if (response == 'l') 
				{
					modules_one = guesser.getCurrentGuess();
					guesser.lower(); 
				}
				if (response == 'r') 
				{
					guesser.reset();
				}
				
			} while (response != 'c');
			
		} while (shouldPlayAgain());
	}
	
	
	public static char promptUserAndGetResponse(int guess) {
		char response;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Is it " + guess + "? (h/l/c/r): ");
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
