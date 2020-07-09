import java.io.*;
import java.time.*;
import java.util.*;

public class ListTester {

    public static void main(String[] args) {

        List<Business> businessList = new ArrayList<Business>(); // run with ArrayList or LinkedList

        LocalDateTime start = LocalDateTime.now();
        fillList(businessList);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Filling the list: \t\t\t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

        // System.out.println("There are " + businessList.size() + " business on the list.");
        // System.out.println("The first business is " + businessList.get(0));
        // System.out.println("The last business is " + businessList.get(businessList.size()-1));
        
       
        start = LocalDateTime.now();
        Business bus = businessList.get(businessList.size() / 2);
        end = LocalDateTime.now();
        System.out.println("Getting a business near the middle of the list: \t" + Duration.between(start, end).toMillis() + " milliseconds.");

        bus = new Business("NOT ON LIST","","","","","","");
        start = LocalDateTime.now();
        businessList.contains(bus);
        end = LocalDateTime.now();
        System.out.println("Determining if a business is on a list: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
        
      
        String businessID = "1046943-12-151";
        start = LocalDateTime.now();
        //bus = findBusinessLoop(businessList, businessID);
        end = LocalDateTime.now();
        System.out.println("Finding the business with the loop \t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

       
        start = LocalDateTime.now();
        bus = findBusinessIterator(businessList, businessID);
        end = LocalDateTime.now();
        System.out.println("Finding the business with the iterator: \t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
        
      
        start = LocalDateTime.now();
        businessList.remove(bus);
        end = LocalDateTime.now();
        System.out.println("Removing the found business: \t\t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");

      
        businessID = "1046939-12-151";
        start = LocalDateTime.now();
        bus = findAndRemoveBusiness(businessList, businessID);
        end = LocalDateTime.now();
        System.out.println("Finding and removing the business with the iterator: \t" + Duration.between(start, end).toMillis() + " milliseconds.");
        
        start = LocalDateTime.now();
        processAllCABusinesses(businessList);
        end = LocalDateTime.now();
        System.out.println("Processing all businesses: \t\t\t\t" + Duration.between(start, end).toMillis() + " milliseconds.");
        
        String zipCode = "94110"; // over 10000 entries
        start = LocalDateTime.now();
        removeZipCodes(businessList, zipCode);
        end = LocalDateTime.now();
        System.out.println("Finding and removing all businesses with the zip code: \t" + Duration.between(start, end).toMillis() + " milliseconds.");
  
    }

    private static Business findBusinessLoop(List<Business> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    private static Business findBusinessIterator(List<Business> list, String id) {
        Iterator<Business> iterator = list.iterator();
        while (iterator.hasNext()) {
            Business b = iterator.next();
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    private static Business findAndRemoveBusiness(List<Business> list, String id) {
        Iterator<Business> iterator = list.iterator();
        while (iterator.hasNext()) {
            Business b = iterator.next();
            if (b.getId().equals(id)) {
                iterator.remove();
                return b;
            }
        }
        return null;
    }
    
    private static int removeZipCodes(List<Business> list, String zipCode) {
        Iterator<Business> iterator = list.iterator();
        int removedCount = 0;
        while (iterator.hasNext()) {
            Business b = iterator.next();
            if (b.getZip().equals(zipCode)) {
                iterator.remove();
                removedCount++;
            }
        }
        return removedCount;
    }

    private static void processAllCABusinesses(List<Business> businessList) {
        Iterator<Business> iterator = businessList.iterator();
        while(iterator.hasNext()) {
            Business business = iterator.next();
            if(business.getState().equals("CA")) {
                business.process();
            }
        }
    }
    
    private static void fillList(List<Business> list) {
        try (Scanner fileScan = new Scanner(new FileReader(new File("SFBus.csv")))) {
            String line = fileScan.nextLine(); // read the column headers

            while (fileScan.hasNext()) {
                line = fileScan.nextLine(); // one line of data

                // this code assumes perfectly formatted input data
                Scanner lineScan = new Scanner(line);
                // System.out.println(line);
                lineScan.useDelimiter(",");
                String id = lineScan.next();
                String ownerName = lineScan.next();
                String name = lineScan.next();
                String street = lineScan.next();
                String city = lineScan.next();
                String state = lineScan.next();
                String zip = lineScan.next();
                Business b = new Business(id, ownerName, name, street, city, state, zip);
                list.add(b);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
