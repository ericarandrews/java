// This program was created to guess a number chosen by the player between a given range.
// The player is asked to guess a number and whether the number guessed by the program is the player’s guess. 
// The player is asked to respond to the programs guess by stating whether the guess is correct, 
// a higher value, or a lower value. 
// This project was completed in Java.

// The programs folder should contain file 'NumberGuessingGame.java' and file 'GuessingProgram.java'
// The program will not run without both files.

public class NumberGuessingGame {
	
	protected int high;
	protected int low;
	
	private int originalHigh;
	private int originalLow;
	
	public NumberGuessingGame(int l, int h) {
		low = originalLow = l;
		high = originalHigh = h;
	}
	
	public int getCurrentGuess() {
		return (high + low) / 2;
	}
	
	public void higher() {
		low = getCurrentGuess() + 1;
	}
	
	public void lower() {
		high = getCurrentGuess() - 1;
	}
	
	public void reset() {
		low = originalLow;
		high = originalHigh;
	}
}
