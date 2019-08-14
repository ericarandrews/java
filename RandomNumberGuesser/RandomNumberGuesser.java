import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser {
	
	private int randomValue;
	private boolean randomValueNeedsUpdating;
	private Random generator;
	
	public RandomNumberGuesser(int l, int h) {
		super(l, h);
		
		randomValueNeedsUpdating = true;
		generator = new Random();
	}
	
	public int getCurrentGuess() {
		
		if(randomValueNeedsUpdating) {
			randomValue = low + (generator.nextInt((high - low) + 1));
			randomValueNeedsUpdating = false;
		}		
		System.out.println(high);
		System.out.println(low);
		return randomValue;
	}
	
	public void higher() {
		super.higher();
		randomValueNeedsUpdating = true;
	}
	
	public void lower() {
		super.lower();
		randomValueNeedsUpdating = true;
	}
	
	public void reset() {
		super.reset();
		randomValueNeedsUpdating = true;
	}
	
}