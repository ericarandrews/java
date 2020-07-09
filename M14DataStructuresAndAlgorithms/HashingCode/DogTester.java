import java.util.*;

public class DogTester {

	public static void main(String[] args) {
		Dog d1 = new Dog("Rover", "Lab Mix", 3, true);
		Dog d2 = new Dog("Spot", "Dalmation", 5, true);
		Dog d3 = new Dog("Frenchie", "Poodle", 1, false);

		// pretend we read this information in from somewhere else- a user, database, etc.
		Dog lookupDog = new Dog("Rover", "Lab Mix", 3, true);
		
		System.out.println("d1==lookupDog? " + (d1==lookupDog));
		System.out.println("d1.equals(lookupDog)? " + (d1.equals(lookupDog)));
		System.out.println("d1 hashCode = " + d1.hashCode());
		System.out.println("lookupDog hashCode = " + lookupDog.hashCode());

		
		ArrayList<Dog> dogList = new ArrayList<>();
		dogList.add(d1);
		dogList.add(d2);
		dogList.add(d3);
		
		System.out.println("lookupDog in the list? " + dogList.contains(lookupDog));
				
		
		Set<Dog> dogSet = new HashSet<>();
		dogSet.add(d1);
		dogSet.add(d2);
		dogSet.add(d3);
		
		System.out.println("lookupDog in the set? " + dogSet.contains(lookupDog));
		


	}

}
