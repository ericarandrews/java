package collectionpractice;


public class Address {

	private String street, state;
	
	public Address(String street, String state) {
		this.street = street;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return street + ", " + state;
	}
}
