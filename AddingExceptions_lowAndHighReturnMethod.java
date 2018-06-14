
//This program is a revision of the Number_Guesser class with added methods and added constructors
public class AddingExceptions_lowAndHighReturnMethod 
{

	private int low;
	private int high;
	private int mid;

	//The higher method changes the value of low
	//The value of low becomes lower
	public void higher(int lower)
	{
		low = lower;
	}

	//The lower method changes the value of high
	//The value of high becomes higher
	public void lower(int higher)
	{
		high = higher;
	}

	//The getCurrentGuess method returns the value of mid
	//@return The value of mid
	public int getCurrentGuess()
	{
		mid = ((high + low)/2);
		return mid;
	}

	//The added getLower method returns the values of high
	//@return The value of high
	public int getLower()
	{
		return high;
	}

	//The added getHigher method returns the values of low
	//@return The value of low
	public int getHigher()
	{
		return low;
	}

	//The reset method changes the values of low and high
	//The value of low and high change to its original values
	public void reset()
	{
		int lowerBound = low;
		int upperBound = high;
	}

}
