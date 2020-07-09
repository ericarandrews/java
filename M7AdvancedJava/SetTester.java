import java.io.*;
import java.time.*;
import java.util.*;

public class SetTester {

    public static void main(String[] args) {

        LocalDateTime start, end;
        
        Set<Business> businessSet = new TreeSet<Business>(); // run with HashSet, TreeSet, or TreeSet using Business.OWNER_NAME_ID_COMPARATOR as a parameter
 
        start = LocalDateTime.now();
        fillSet(businessSet);
        end = LocalDateTime.now();
        System.out.println("Filling the set: \t\t\t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
        
        
        String businessID = "0000024-02-999"; // 0000024-02-999 1046943-12-151
        start = LocalDateTime.now();
        Business bus = findBusinessIterator(businessSet, businessID);
        end = LocalDateTime.now();
        System.out.println("Finding the business with the iterator: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

     
        start = LocalDateTime.now();
        processAllCABusinesses(businessSet, 0);
        end = LocalDateTime.now();
        System.out.println("Processing all businesses: \t\t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
       
        
        bus = new Business("NOT ON LIST","","","","","","");
        start = LocalDateTime.now();
        businessSet.contains(bus);
        end = LocalDateTime.now();
        System.out.println("Determining if a business is on a list: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
         
        
    }
    
    private static void fillSet(Set<Business> set) {
        try (Scanner fileScan = new Scanner(
                new FileReader(new File("SFBus.csv")))) {
            String line = fileScan.nextLine(); // column headers
            //System.out.println(line);
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
                boolean success = set.add(b);
                if(!success) {
                    System.out.println("Failed to add a business " + b.getId());
                }
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static Business findBusinessIterator(Set<Business> list, String id) {
        Iterator<Business> iterator = list.iterator();
        while (iterator.hasNext()) {
            Business b = iterator.next();
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
    
    private static void processAllCABusinesses(Set<Business> businessList, int printNum) {
        Iterator<Business> iterator = businessList.iterator();
        int countProcessed = 0;
        while(iterator.hasNext()) {
            Business business = iterator.next();
            if(business.getState().equals("CA")) {
                business.process();
                if(countProcessed < printNum) {
                    System.out.println(business);
                    countProcessed++;
                }
            }
        }
    }
}
