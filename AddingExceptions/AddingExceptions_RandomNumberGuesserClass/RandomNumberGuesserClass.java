import java.util.Random;

public class RandomNumberGuesserClass extends NumberGuesserClass{

	Random variable = new Random();
	protected int randomNumber;

	public RandomNumberGuesserClass(int lowerBound, int upperBound) 
	{
		super(lowerBound, upperBound);
		low = lower = lowerBound;
		high = higher = upperBound;
	} 
	
	public int getCurrentGuess()
	{
		int vInt = variable.nextInt((high -low) + 1);	
		randomNumber = vInt + low;
	
		try{
			
			if(low == high) 
			{	
				throw new IllegalStateException();
			}
			if(low < lower)
			{
				throw new IllegalStateException();
			}
			if(high > higher)
			{
				throw new IllegalStateException();
			}
			
		}
		catch(IllegalStateException e)
		{
			System.out.println("\nYou have been caught cheating!\n" +
				"Your number has been guessed.");	
			reset();
		}
		
		return randomNumber;
	}	
	
	public void higher()
	{
		if(low != randomNumber && high != randomNumber)
		{
			low = randomNumber + 1; 
		}
		else
		{
			low = randomNumber;
		}
	}
	public void lower()
	{
		if(high != randomNumber && low != randomNumber)
		{
			high = randomNumber - 1;
		}
		else
		{
			high = randomNumber;
		}
	}
	public void reset()
	{
		super.reset();
	}
}
