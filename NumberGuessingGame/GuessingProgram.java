//This program was created to guess a number chosen by the player between a given range.
// The player is asked to guess a number and whether the number guessed by the program is the player’s guess. 
// The player is asked to respond to the programs guess by stating whether the guess is correct, 
// a higher value, or a lower value. 
// This project was completed in Java.

//The programs folder should contain file 'NumberGuessingGame.java' and file 'GuessingProgram.java'
//The program will not run without both files.

import java.util.Scanner;

public class GuessingProgram
{
	public static void main(String[] args) 
	{		
		do 
		{
			playGame();
		}
		
		while (shouldPlayAgain());	
	}	

			public static void playGame()
			{	
				System.out.println("\nWelcome to the Number Guessing Game. Think of a number between 1 and 100... \n");
				int lowerBound = 0;
				int upperBound = 101;
				char guess;
				NumberGuessingGame guesser = new NumberGuessingGame(lowerBound, upperBound);

				do
				{
					// users guess placed within method/function guesser.getCurrentGuess();
					System.out.println("Is it " + guesser.getCurrentGuess() + "?"); 
					System.out.print("Enter 'h' for higher, 'l' for lower, 'c' for correct, or 'r' to reset: ");	
					Scanner input = new Scanner(System.in);
					guess = input.next().charAt(0);
								
					//void higher method
					if(guess == 'h')
					{
						guesser.higher();
					} 

					//void lower method
					else if(guess == 'l')
					{
						guesser.lower();
					}
					
					//getCurrentGuess method
					else if(guess == 'c')
					{
						System.out.println("You picked " + guesser.getCurrentGuess() + "!");
						System.out.println("Good Game!");
							
					}
					
					//void reset method
					else if(guess == 'r')
					{
						guesser.reset();
					}
				}
				while(guess != 'c'); 
		}	

			public static boolean shouldPlayAgain()
			{
				System.out.print("\nEnter yes or no to play again: ");
				Scanner input = new Scanner(System.in);
				char playAgain = input.next().charAt(0);
			
				if (playAgain == 'y')
				{
				return true;
				}
				else return false;	
			}
}
