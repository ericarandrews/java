
public class InvalidZipCodeException extends Exception {
	
	private static final String MESSAGE = "Invalid zip code.";
	
	public InvalidZipCodeException() {
		super(MESSAGE);
	}
	
	public InvalidZipCodeException(String message) {
		super(message);
	}
	
	

}
