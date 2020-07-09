import java.io.*;
import java.time.*;
import java.util.*;

public class MapTester {

	public static void main(String[] args) {

		LocalDateTime start, end;

		
		Map<String, Business> businessMap = new TreeMap<>(); // run with HashMap or TreeMap 
		start = LocalDateTime.now();
		fillMapByID(businessMap);
		end = LocalDateTime.now();
		System.out.println("Filling the map: \t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

		System.out.println("There are " + businessMap.size() + " key-value pairs.");
		
		
		String businessID = "0000024-02-999"; // 0000024-02-999 1046943-12-151
		start = LocalDateTime.now();
		Business bus = businessMap.get(businessID);
		end = LocalDateTime.now();
		System.out.println("Finding the business: \t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

	
        start = LocalDateTime.now();
        processAllCABusinesses(businessMap, 5);
        end = LocalDateTime.now();
        System.out.println("Processing all businesses: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
	
        
		
        Map<String, List<Business>> businessOwnerMap = new TreeMap<>(); // run with HashMap or TreeMap 
        start = LocalDateTime.now();
        fillMapByOwnerName(businessOwnerMap);
        end = LocalDateTime.now();
        System.out.println("Filling the map: \t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
       
        System.out.println("There are " + businessOwnerMap.size() + " key-value pairs.");
       
        start = LocalDateTime.now();
        printOwnerMultipleBusiness(businessOwnerMap, 80);
        end = LocalDateTime.now();
        System.out.println("Processing all businesses: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
	
		compareMapOrdering();  
		demonstrateBackedByCollection();
	
	
	}
	
	private static void fillMapByID(Map<String,Business> map) {
        try (Scanner fileScan = new Scanner(
                new FileReader(new File("SFBus.csv")))) {
            String line = fileScan.nextLine(); // column headers

            while(fileScan.hasNext()) {
                line = fileScan.nextLine();
                
                // this structure assumes perfectly formatted input data
                Scanner lineScan = new Scanner(line);
                //System.out.println(line);
                lineScan.useDelimiter(",");
                String id = lineScan.next();
                String ownerName = lineScan.next();
                String name = lineScan.next();
                String street = lineScan.next();
                String city = lineScan.next();
                String state = lineScan.next();
                String zip = lineScan.next();
                Business b = new Business(id, ownerName, name, street, city, state, zip);
               
                map.put(id, b);
            }
    
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

	private static void processAllCABusinesses(Map<String,Business> map, int printCount) {
	    int recordsPrinted = 0;
	    
	    Collection<Business> values = map.values();
	    Iterator<Business> iterator = values.iterator();
	    while(iterator.hasNext()) {
	        Business business = iterator.next();
            if(business.getState().equals("CA")) {
                business.process();
                if(recordsPrinted < printCount){
                    System.out.println(business);
                    recordsPrinted++;
                }
                    
            }
	    }
	}
		
	private static void fillMapByOwnerName(Map<String,List<Business>> map) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File("SFBus.csv")))) {
			String line = fileScan.nextLine(); // column headers

			while(fileScan.hasNext()) {
				line = fileScan.nextLine();
				
				// this structure assumes perfectly formatted input data
				Scanner lineScan = new Scanner(line);
				//System.out.println(line);
				lineScan.useDelimiter(",");
				String id = lineScan.next();
				String ownerName = lineScan.next();
				String name = lineScan.next();
				String street = lineScan.next();
				String city = lineScan.next();
				String state = lineScan.next();
				String zip = lineScan.next();

                Business b = new Business(id, ownerName, name, street, city, state, zip);

                if(map.containsKey(ownerName)) {
                    
                    List<Business> businessList = map.get(ownerName);
                    
                    if(businessList==null) {
                        businessList = new ArrayList<Business>();
                    }
                    
                    businessList.add(b);
                  //  map.replace(ownerName, businessList);
                } else {
                    List<Business> businessList = new ArrayList<Business>();
                    businessList.add(b);
                    map.put(ownerName,  businessList);
                }
			}    
	
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void printOwnerMultipleBusiness(Map<String,List<Business>> map, int businessCount) {
	    Set<String> ownerNames = map.keySet();
	    Iterator<String> iterator = ownerNames.iterator();
	    while(iterator.hasNext()) {
	        String ownerName = iterator.next();
	        List<Business> businessList = map.get(ownerName);
	        int numberOfBusinesses = businessList.size();
	        if(numberOfBusinesses >= businessCount) {
	            System.out.println(ownerName + " owns " + numberOfBusinesses + " businesses.");
	        }
	    }
	}
	
	private static void compareMapOrdering() {
        Employee e1 = new Employee("A123");
        Employee e2 = new Employee("B456");
        Employee e3 = new Employee("C789");
        Employee e4 = new Employee("B897");
        
        Map<String,Employee> map = new HashMap<>(); // HashMap TreeMap LinkedHashMap
        map.put(e1.getId(), e1);
        map.put(e2.getId(), e2);
        map.put(e3.getId(), e3);
        map.put(e4.getId(), e4);
        
        Set<String> keys = map.keySet();
        for(String employeeID : keys) {
            System.out.println(map.get(employeeID)); 
        }
        
    }
	private static void demonstrateBackedByCollection() {
	    
        Set<String> mySet = new HashSet<>();
        mySet.add("hello");
        mySet.add("hi");
        mySet.add("bye");
        mySet.add("hi");
        System.out.println(mySet);
        mySet.remove("bye");
        System.out.println(mySet);
        
        Employee e1 = new Employee("A123");
        Employee e2 = new Employee("B456");
        Employee e3 = new Employee("C789");
        Employee e4 = new Employee("B897");
        
    
        Map<String,Employee> map = new HashMap<>(); // HashMap TreeMap LinkedHashMap
        map.put(e1.getId(), e1);
        map.put(e2.getId(), e2);
        map.put(e3.getId(), e3);
        map.put(e4.getId(), e4);

        Set<String> employeeKeys = map.keySet();
        System.out.println("At start:\t\t\t\t" + employeeKeys.size() + " employee keys");
        System.out.println("At start:\t\t\t\t" + map.size() + " employee key-value pairs");
        
        //employeeKeys.add("EMPID");
        //System.out.println(employeeKeys.size() + " employee keys");
      
        employeeKeys.remove("A123");
        System.out.println("After remove from keySet:\t\t" + employeeKeys.size() + " employee keys");
        System.out.println("After remove from keySet:\t\t" + map.size() + " employee key-value pairs");
      
        map.remove("B456");
        System.out.println("After remove from map:\t\t\t" + employeeKeys.size() + " employee keys");
        System.out.println("After remove from map:\t\t\t" + map.size() + " employee key-value pairs");
       

        Iterator<String> iterator = employeeKeys.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            if(key.equals("C789")) {
                iterator.remove();
            }
        }
        
        System.out.println("After remove from keySet iterator:\t" + employeeKeys.size() + " employee keys");
        System.out.println("After remove from keySet iterator:\t" + map.size() + " employee key-value pairs");
      
        map.put("F444",  new Employee("F444"));
        System.out.println("After adding to the map:\t\t" + employeeKeys.size() + " employee keys");
        System.out.println("After adding to the map:\t\t" + map.size() + " employee key-value pairs");
       
 	}
	
}
