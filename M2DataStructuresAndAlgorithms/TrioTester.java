import java.util.ArrayList;

//Submitted!
//Sep 16 at 10:25pm
//Submission Details
//Download Trio.java
//Grade: 40 (100 pts possible)
//Graded Anonymously: no
//Comments:
//-5 only one constructor is provided -20 missing equals method JM Please Review reset, count, and hasDuplicates methods
//Dequan Zhang, Sep 21 at 12:34pm
//-7 reset method does not work- need to flip the order of the assignment statements -14 count method should take in a parameter of type T, not be two different methods for Strings and ints; also, needs to examine how many times the parameter shows up in the Trio -14 similar for hasDuplicates- need to work for all data types T and need to examine the three elements for duplicates post a comment here if you want to discuss a possible revision.
//Jessica Masters, Sep 23 at 11:31am

public class TrioTester {

	public static void main(String[] args) {

		Trio<Integer> numberTrio = new Trio<Integer>(3, 4, 5);
		/* 
		 * un-comment the line of code below and it should cause a compiler error because trio1 should only accept Strings
		 */
		//numberTrio.setItem2("apple");
		
		System.out.println("***TESTING TOSTRING METHOD***");
		System.out.println("Should print a text representation of the Trio that contains 3, 4, 5:");
		System.out.println(numberTrio);
		
		System.out.println("\n***TESTING GETTERS AND SETTERS METHOD***");
		System.out.println("Item 1 should be 3: " + numberTrio.getItem1());
		System.out.println("Item 2 should be 4: " + numberTrio.getItem2());
		System.out.println("Item 3 should be 5: " + numberTrio.getItem3());
		numberTrio.setItem1(6);
		numberTrio.setItem2(7);
		numberTrio.setItem3(8);
		System.out.println("Item 1 should be 6: " + numberTrio.getItem1());
		System.out.println("Item 2 should be 7: " + numberTrio.getItem2());
		System.out.println("Item 3 should be 8: " + numberTrio.getItem3());	
			
		System.out.println("\n***TESTING HASDUPLICATES METHOD***");				
		System.out.println("Trio contains duplicates? false: " + numberTrio.hasDuplicates());
		numberTrio.setItem2(6);
		System.out.println("Trio contains duplicates? true: " + numberTrio.hasDuplicates());
		numberTrio.setItem3(6);
		System.out.println("Trio contains duplicates? true: " + numberTrio.hasDuplicates());
		
		System.out.println("\n***TESTING COUNT METHOD***");
		numberTrio.setItem1(0);
		numberTrio.setItem2(2);
		numberTrio.setItem3(3);
		System.out.println("Trio contains how many 1s? 0: " + numberTrio.count(1));
		numberTrio.setItem1(1);
		System.out.println("Trio contains how many 1s? 1: " + numberTrio.count(1));
		numberTrio.setItem2(1);
		System.out.println("Trio contains how many 1s? 2: " + numberTrio.count(1));
		numberTrio.setItem3(1);
		System.out.println("Trio contains how many 1s? 3: " + numberTrio.count(1));
		
		System.out.println("\n***TESTING RESET METHOD***");
		numberTrio.reset(43);
		System.out.println("Should print a text representation of the Trio that contains 43, 43, 43:");
		System.out.println(numberTrio);
		System.out.println("Trio contains how many 43s? 3: " + numberTrio.count(43));
		System.out.println("Trio contains duplicates? true: " + numberTrio.hasDuplicates());
		
		Trio<String> wordTrio = new Trio<String>("hello");
		wordTrio.setItem2("goodbye");
		wordTrio.setItem3("nice knowing you");
		/* 
		 * un-comment the line of code below and it should cause a compiler error because wordTrio should only accept Strings
		 */
		//wordTrio.setItem2(3);

		
		System.out.println("\n***TESTING COUNT METHOD***");			
		String testString1 = new String("hello");
		String testString2 = new String("HELLO");
		System.out.println("Trio contains how many hello? 1: " + wordTrio.count(testString1));
		System.out.println("Trio contains how many HELLO? 0: " + wordTrio.count(testString2));

		System.out.println("\n***TESTING EQUALS METHOD***");	
		// no duplicates, same items in same order
		Trio<String> wordTrio2 = new Trio<String>(new String("a"), new String("b"), new String("c"));
		Trio<String> wordTrio3 = new Trio<String>(new String("a"), new String("b"), new String("c"));
		System.out.println("Trios the same? true: " + wordTrio2.equals(wordTrio3));
		
		// no duplicates, same items in different order
		Trio<Integer> numberTrio2 = new Trio<Integer>(5, 6, 8);
		Trio<Integer> numberTrio3 = new Trio<Integer>(8, 5, 6);
		System.out.println("Trios the same? true: " + numberTrio2.equals(numberTrio3));
		
		// different items
		numberTrio2.setItem2(5);
		System.out.println("Trios the same? false: " + numberTrio2.equals(numberTrio3));
		System.out.println("Trios the same? false: " + numberTrio2.equals(wordTrio));
		System.out.println();
		
		// same items, but different items are duplicated
		Trio<Integer> numberTrio4 = new Trio<Integer>(1, 1, 2);
		Trio<Integer> numberTrio5 = new Trio<Integer>(1, 2, 2);
		System.out.println("Trios the same? false: " + numberTrio4.equals(numberTrio5));

		// same items, but different items are duplicated
		Trio<Integer> numberTrio14 = new Trio<Integer>(1, 2, 1);
		Trio<Integer> numberTrio15 = new Trio<Integer>(1, 1, 2);
		System.out.println("Trios the same? true : " + numberTrio14.equals(numberTrio15));
				
		
	}

}
