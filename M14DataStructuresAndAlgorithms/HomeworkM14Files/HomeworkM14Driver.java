import java.util.*;

public class HomeworkM14Driver {

	public static void main(String[] args) {
	
		System.out.println("***************TESTING EQUALS AND HASHCODE METHOD IN STUDENT CLASS");
		System.out.println("***Testing with equivalent students:");
		Student testStudent = new Student(123, "Sam", "Studier", true);
		Set<Student> studentSet = new HashSet<>();
		Student equiv1 = new Student(123, "Sam", "Studier", true);
		Student equiv2 = new Student(Integer.valueOf(123), new String("Sam"), new String("Studier"), Boolean.valueOf(true));
		System.out.println("testStudent and equiv1 equivalent \ttrue:  " + testStudent.equals(equiv1));
		System.out.println("testStudent and equiv2 equivalent \ttrue:  " + testStudent.equals(equiv2));		
		System.out.println("testStudent and equiv1 same hashCode \ttrue:  " + (testStudent.hashCode()== equiv1.hashCode()));
		System.out.println("testStudent and equiv2 same hashCode \ttrue:  " + (testStudent.hashCode()==equiv2.hashCode()));
		System.out.println("Add testStudent to a set\t\ttrue:  " + studentSet.add(testStudent));
		System.out.println("Try to add testStudent again \t\tfalse: " + studentSet.add(testStudent));
		System.out.println("Try to add equiv1  \t\t\tfalse: " + studentSet.add(equiv1));
		System.out.println("Try to add equiv2 \t\t\tfalse: " + studentSet.add(equiv2));
		
		System.out.println("\n***Testing equals method with non-equivalent students:");
		Student differentStudent = new Student(123, "Sam", "Studier", false);
		System.out.println("testStudent and differentStudent equivalent \tfalse: " + testStudent.equals(differentStudent));
		differentStudent = new Student(123, "Sam", "StudierMore", true);
		System.out.println("testStudent and differentStudent equivalent \tfalse: " + testStudent.equals(differentStudent));
		differentStudent = new Student(123, "Sammy", "Studier", true);
		System.out.println("testStudent and differentStudent equivalent \tfalse: " + testStudent.equals(differentStudent));
		differentStudent = new Student(1123, "Sam", "Studier", true);
		System.out.println("testStudent and differentStudent equivalent \tfalse: " + testStudent.equals(differentStudent));

		System.out.println("\n***Testing equals/hashCode contract with non-equivalent students:");
		differentStudent = new Student(456, "Sam", "Studier", true);
		boolean same = testStudent.equals(differentStudent);
		if(same) {
			System.out.println("Your equals method says testStudent and differentStudent with the same names but different IDs are equal. \n\tThey shouldn't be because they have different IDs!");
			System.out.println("\tBut, since they are equal, they should also have the same hashcode.");
			System.out.println("\tSame hashCode test3 \t\t\ttrue: " + (testStudent.hashCode()==differentStudent.hashCode()));
		} else {
			System.out.println("testStudent and differentStudent equivalent \tfalse: " + same);
		}
		differentStudent = new Student(123, "Pat", "Procrastinator", false);
		same = testStudent.equals(differentStudent);
		if(same) {
			System.out.println("Your equals method says testStudent and differentStudent with the same ID but different names are equal. \n\tThey shouldn't be because they have different names!");
			System.out.println("\tBut, since they are equal, they should also have the same hashcode.");
			System.out.println("\tSame hashCode test4 \t\ttrue: " + (testStudent.hashCode()==differentStudent.hashCode()));
		} else {
			System.out.println("testStudent and differentStudent equivalent \tfalse: " + same);
		}		
		

		int[] tableSizes = {5, 2, 10};
		for (int tableSize : tableSizes) {
			System.out.println("\n***************TESTING WITH TABLE SIZE " + tableSize);
			System.out.println("\n*****TESTING ADD TO VOTER HASHTABLE");
			Voter v1 = new Voter(912, "Delta Dem");
			Voter v2 = new Voter(670, "Rita Rep");
			Voter v3 = new Voter(381, "Ida Inde");
			Voter v4 = new Voter(497, "Greta Green");
			Voter v5 = new Voter(301, "Liz Libert");
			Voter v6 = new Voter(541, "Ursula Undec");

			Voter[] theVoters = { v1, v2, v3, v4, v5, v6 };

			VoterHashTableSeparateChaining voterTable = new VoterHashTableSeparateChaining(tableSize);
			System.out.println("Each voter should be added to the table- each should print true.");
			for (Voter v : theVoters) {
				System.out.println("Added " + v.getName() + "  \ttrue: " + voterTable.addVoter(v));
			}
			System.out.println("\nCompare your table to the location of where each voter should be. They should match.");
			System.out.println("\nHere is your table:");
			voterTable.printTable();
			System.out.println();

			System.out.println("The locations below should match the table above.");
			for (Voter v : theVoters) {
				System.out.println(v.getName() + "\tLocation " + voterTable.getHashTableLocation(v.getId()));
			}

			
			System.out.println("\n*****TESTING RETRIEVE FROM");
			System.out.println("Get these voters based on their ID. The voter retrieved should match what is asked for.");
			for (Voter v : theVoters) {
				System.out.println("Retreiving " + v.getId() + " (" + v.getName() + ") \t: " + voterTable.getVoter(v.getId()));

			}
			Voter v7 = new Voter(412, "Nancy NotAVoter");
			System.out.println("Retrieved Nancy NotAVoter? \tshould be null: " + voterTable.getVoter(v7.getId()));
			
			
			// COMMENT THIS SECTION OUT IF COMPLETING THE EXTRA CREDIT
			System.out.println("\n*****TESTING EXTRA CREDIT- NO ADDING DUPLICATES");
			System.out.println("These voters are duplicates and should not be added- each should print false.");
			for (Voter v : theVoters) {
				System.out.println(v.getName() + "    added again?\t\t\tfalse: " + voterTable.addVoter(v));
			}			
			System.out.println("Equivalent of Delta Dem added?\t\t\tfalse: " + voterTable.addVoter(new Voter(912, "Delta Dem")));
			System.out.println("Equivalent of Delta Dem added?\t\t\tfalse: " + voterTable.addVoter(new Voter(Integer.valueOf(912), new String("Delta Dem"))));
			System.out.println("Equivalent of Ursula Undec again?\t\tfalse: " + voterTable.addVoter(new Voter(541, "Ursula Undec")));
			System.out.println("Equivalent of Ursula Undec again?\t\tfalse: " + voterTable.addVoter(new Voter(Integer.valueOf(541), new String("Ursula Undec"))));

		}
	}	
}
