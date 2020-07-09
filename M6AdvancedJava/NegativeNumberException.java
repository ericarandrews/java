
public class NegativeNumberException  extends Exception {
	
	private static final String MESSAGE = "Negative number";
	
	public NegativeNumberException() {
		super(MESSAGE);
	}
	public NegativeNumberException(String message) {
		super(message);
	}

}


