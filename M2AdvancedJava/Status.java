
public enum Status {

	ACTIVE ("AC", "Active Employee"), INACTIVE_TEMP ("IT", "Temporarily Inactive"), INACTIVE_PERM ("IP", "Permanently Inactive");
	
	private String statusCode;
	private String outputString;
	
	private Status(String statusCode, String outputString) {
		this.statusCode = statusCode;
		this.outputString = outputString;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	@Override
	public String toString() {
		return outputString;
	}
	
}
