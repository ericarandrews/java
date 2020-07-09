
public class Address {

	private String number, street, street2, city, state, zip1, zip2, country;
	
	private Address(AddressBuilder builder) {
		this.number = builder.number;
		this.street = builder.street;
		this.street2 = builder.street2;
		this.city = builder.city;
		this.state = builder.state;
		this.zip1 = builder.zip1;
		this.zip2 = builder.zip2;
		this.country = builder.country;
		
	}
	
	
	public static class AddressBuilder {
		private String number, street, zip1;
		private String street2 = "", city = "", state = "", zip2 = "", country = "";
		
		public AddressBuilder(String number, String street, String zip1) {
			this.number = number;
			this.street = street;
			this.zip1 = zip1;
		} 
		public AddressBuilder() {
			
		}
		public AddressBuilder number(String var) {
			this.number = var;
			return this;
		}
		public AddressBuilder street(String var) {
			this.street = var;
			return this;
		}
		public AddressBuilder zip1(String var) {
			this.zip1 = var;
			return this;
		}
		
		public AddressBuilder street2(String var) {
			this.street2 = var;
			return this;
		}
		public AddressBuilder city(String var) {
			this.city = var;
			return this;
		}
		public AddressBuilder state(String var) {
			this.state = var;
			return this;
		}
		public AddressBuilder zip2(String var) {
			this.zip2 = var;
			return this;
		}
		public AddressBuilder country(String var) {
			this.country = var;
			return this;
		}
		public Address build() {
			Address address = new Address(this);
			
			if(number==null || street == null || zip1==null) {
				throw new IllegalStateException();
			}
			
			return address;
		}
		
		
	}
}
