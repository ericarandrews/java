import java.util.*;

public class CustomerTester {

	public static void main(String[] args) {
		HashMap<String, Customer> customerMap = new HashMap<>();
		fillCustomers(customerMap);
		
		System.out.println("There are " + customerMap.size() + " entries in the table.");
		
		Set<String> keys = customerMap.keySet();
		System.out.println("Keys are " + keys);
		for(String key : keys) {
			// do something with each key
		}
		
		Collection<Customer> customers = customerMap.values();
		System.out.println("Customers are " + customers);
		for(Customer c : customers) {
			// do something with each customer c
		}
		Scanner scan = new Scanner(System.in);
		/*
		// retrieve an element
		
		System.out.print("Enter the ID: ");
		String id = scan.nextLine();
		//id = id.toUpperCase();
		
		Customer customer = customerMap.get(id);
		System.out.println(customer);
		if(customer!=null) {
			// check before invoking any methods on customer
		}
		*/
		
		/*
		// add an element
		System.out.println("Enter the name: ");
		String name = scan.nextLine();
		System.out.println("Enter the id: ");
		String id = scan.nextLine();

		Customer c = customerMap.put(id,  new Customer(name, id));
		System.out.println("There are " + customerMap.size() + " entries in the table.");
		System.out.println("the replaced customer is " + c);
		customers = customerMap.values();
		System.out.println("Customers are " + customers);
		*/
		
		// remove an element
		System.out.print("Enter the ID to remove: ");
		String id = scan.nextLine();		

		Customer customer = customerMap.remove(id);
		System.out.println(customer);
		System.out.println("There are " + customerMap.size() + " entries in the table.");
		
	}
	
	public static void fillCustomers(HashMap<String,Customer> custList) {
		custList.put("AZ14", new Customer("Adam Zapel", "AZ14"));
		custList.put("AD62", new Customer("Al Dente", "AD62"));
		custList.put("AF67", new Customer("Al Fresco", "AF67"));
		custList.put("ASG1", new Customer("Al K. Seltzer","ASG1"));
		custList.put("ARHC", new Customer("Alf A. Romeo", "ARHC"));
		custList.put("ALH1", new Customer("Amanda Lynn", "ALH1"));
		custList.put("AJ71", new Customer("Anita Job", "AJ71"));
		custList.put("AC4G", new Customer("Anna Conda", "AC4G"));
		custList.put("AGB1", new Customer("Anna Graham", "AGB1"));
		custList.put("APL2", new Customer("Anna Prentice", "APL2"));
		custList.put("AS1G", new Customer("Anna Sasin", "AS1G"));
		custList.put("ATH9", new Customer("Anne Teak", "ATH9"));
		custList.put("BW90", new Customer("B.A. Ware", "BW90"));
		custList.put("BDC1", new Customer("Barb Dwyer", "BDC1"));
		custList.put("BD31", new Customer("Barb E. Dahl", "BD31"));
		custList.put("BS20", new Customer("Barbara Seville", "BS20"));
		custList.put("BCG5", new Customer("Barry Cade", "BCG5"));
		custList.put("BMJ7", new Customer("Bea Minor", "BMJ7"));
		custList.put("DM78", new Customer("Dee Major", "DM78"));
		custList.put("BT65", new Customer("Beau Tye", "BT65"));
		custList.put("BB53", new Customer("Bill Board", "BB53"));
		custList.put("CV62", new Customer("Cara Van", "CV62"));
		custList.put("CPA1", new Customer("Chris P. Bacon","CPA1"));
		custList.put("CN6T", new Customer("Constance Noring", "CN6T"));
		custList.put("CB41", new Customer("Crystal Ball", "CB41"));
		custList.put("CGG4", new Customer("Crystal Glass", "CGG4"));
		custList.put("ER39", new Customer("Earl Lee Riser", "ER39"));
		custList.put("EW12", new Customer("Easton West", "EW12"));
		custList.put("FW36", new Customer("Ferris Wheeler","FW36"));
		custList.put("F613", new Customer("Flint Sparks","F613"));
		custList.put("FS13", new Customer("Franklin Stein", "FS13"));
		custList.put("GP19", new Customer("Gene Poole", "GP19"));
		custList.put("HC84", new Customer("Heidi Clare", "HC84"));
		custList.put("HBB5", new Customer("Helen Back", "HBB5"));
		custList.put("HW03", new Customer("Helen Wiells", "HW03"));
		custList.put("HM00", new Customer("Holly McRell", "HM00"));
		custList.put("HW32", new Customer("Holly Wood", "HW32"));
		custList.put("JP87", new Customer("Jack Pott", "JP87"));
		custList.put("JK87", new Customer("Joe Kerr", "JK87"));
		custList.put("JR64", new Customer("Joy Rider", "JR64"));
		custList.put("JCT1", new Customer("Justin Case", "JCT1"));
		custList.put("JT13", new Customer("Justin Time", "JT13"));
		custList.put("KA74", new Customer("Kandi Apple", "KA74"));
		custList.put("LNB4", new Customer("Laura Norder", "LNB4"));
		custList.put("LK71", new Customer("Leigh King", "LK71"));
		custList.put("LW13", new Customer("Luke Warm", "LW13"));
		custList.put("MM44", new Customer("Marsha Mellow", "MM44"));
		custList.put("MLQ3", new Customer("Marshall Law", "MLQ3"));
		custList.put("MG63", new Customer("Marty Graw", "MG63"));
		custList.put("OB63", new Customer("Olive Branch","OB63"));
		custList.put("PTC8", new Customer("Paige Turner", "PTC8"));
		custList.put("PR94", new Customer("Pepe Roni", "PR94"));
		custList.put("PW17", new Customer("Price Wright", "PW17"));
		custList.put("RB12", new Customer("Rocky Beach", "RB12"));
		custList.put("SB12", new Customer("Sandy Beach", "SB12"));
		custList.put("SM62", new Customer("Sal A. Mander", "SM62"));
		custList.put("SC89", new Customer("Stanley Cupp", "SC89"));
		custList.put("TM43", new Customer("Tom Morrow", "TM43"));
		custList.put("WP90", new Customer("Warren Peace", "WP90"));
		custList.put("WP91", new Customer("Will Power", "WP91"));
		custList.put("XB43", new Customer("X. Benedict", "XB43"));
	}
		



}
