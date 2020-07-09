public class AddressOld {
	
	private String number, street, street2, city, state, zip1, zip2, country;
	
	private static final String DEFAULT_STREET2 = "";
	private static final String DEFAULT_ZIP2 = "";

	public AddressOld() {
		
	}
	
	public AddressOld(String number, String street, String street2, String city, String state, String zip1, String zip2, String country) {
		this.number = number;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip1 = zip1;
		this.zip2 = zip2;
		this.country = country;
	}
	public AddressOld(String number, String street, String city, String state, String zip1, String zip2, String country) {
			this(number, street, DEFAULT_STREET2, city, state, zip1, zip2, country);
	}
	public AddressOld(String number, String street, String city, String state, String zip1, String country) {
			this(number, street, DEFAULT_STREET2, city, state, zip1, DEFAULT_ZIP2, country);
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip1() {
		return zip1;
	}

	public void setZip1(String zip1) {
		this.zip1 = zip1;
	}

	public String getZip2() {
		return zip2;
	}

	public void setZip2(String zip2) {
		this.zip2 = zip2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
