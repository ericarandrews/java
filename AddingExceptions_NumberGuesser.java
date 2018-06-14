
public class AddingExceptions_NumberGuesser {
	
	protected int high;
	protected int low;
	
	private int lower;
	private int higher;
	
	public AddingExceptions_NumberGuesser(int lowerBound, int upperBound) {
		low = lower = lowerBound;
		high = higher = upperBound;
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
		low = lower;
		high = higher;
	}
}
