
public class AddingExceptions_NumberGuesserClass {
	protected int high;
	protected int low;
	
	protected int lower;
	protected int higher;
	
	public AddingExceptions_NumberGuesserClass(int lowerBound, int upperBound) 
	{
		low = lower = lowerBound;
		high = higher = upperBound;
	}
	public int getCurrentGuess() 
	{
		return (high + low) / 2;
	}
	public void higher() 
	{
		low = getCurrentGuess() + 1;
	}
	public void lower() 
	{
		high = getCurrentGuess() - 1;
	}
	public void reset() 
	{
		low = lower;
		high = higher;
	}
}
