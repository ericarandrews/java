
public class AddressTester {
	
	public static void main(String[] args) {
		AddressOld address1 = new AddressOld("50", "Phelan Ave", "San Francisco", "CA", "94112", "0000", "USA");
		AddressOld address2 = new AddressOld("101", "Main Street", "Apt 2", "Anytown", "NY", "12345", "0000", "USA");

		AddressOld address3 = new AddressOld();
		address3.setNumber("50");
		address3.setStreet("Phelan Ave");
		
		Address a1 = new Address.AddressBuilder("50", "Phelan", "94112")
				.state("CA")
				.city("San Francisco")
				.zip2("000")
				.country("USA")
				.build();
		Address a2 = new Address.AddressBuilder()
				.number("50")
				.street("Phelan")
				.state("CA")
				.city("San Francisco")
				.zip1("94112")
				.zip2("000")
				.country("USA")
				.build();
				
		
	}

}
