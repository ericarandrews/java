import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class HomeworkM11Streams {

	public static List<Customer> customerList = null;
		
	public static void main(String[] args) throws Exception {

		customerList = new ArrayList<>();
		fillList(customerList);	
	
		// Q1: How many customers in CA?
		System.out.print("Q1: Should print 20: ");
		long caCustomers = q1();
		System.out.println(caCustomers);
		
		// Q2: Create a list of all priority customers in MA.
		System.out.println("\nQ2: Should print \n[ Sasin, Anna (ID: AS1G) (Priority Customer),  Case, Justin (ID: JCT1) (Priority Customer)]");
		List<Customer> maPriorityList = q2();
		System.out.println(maPriorityList);

		// Q3: How much money have all customers spent (combined)?
		System.out.print("\nQ3: Should print 330518.0: ");
		double total = q3();
		System.out.println(total);
		
		// Q4: How much money have all priority customers spent (combined)?
		System.out.print("\nQ4: Should print 226177.0: ");
		double priorityTotal = q4();
		System.out.println(priorityTotal);
		
		// Q5: Create a map of all WY priority customers (key=id, value=customer)
		System.out.println("\nQ5: Should print\n{BS20= Seville, Barbara (ID: BS20) (Priority Customer), BCG5= Cade, Barry (ID: BCG5) (Priority Customer), LK71= King, Leigh (ID: LK71) (Priority Customer), PTC8= Turner, Paige (ID: PTC8) (Priority Customer)}");
		Map<String, Customer> wyCustomers = q5();
		System.out.println(wyCustomers);
		
		// Q6: What is the greatest amount of money spent by a NY priority customer?
		System.out.print("\nQ6: Should print 9207.0: ");
		double nyHighAmount = q6();
		System.out.println(nyHighAmount);
		
		//Q7: Find all customers that spent > 9000.
		// Print a comma-separated String of all customer IDs for customers that spent > 9000:
		System.out.println("\nQ7: Should print: \nAD62,AS1G,CV62,HW32,JCT1,KA74,OB63,PTC8,WP90");
		String highIDList = q7();
		System.out.println(highIDList);
		
		//Q8: Find any customer that has spent > 9800. 
		// Print the amount spent by the customer. If there is none, nothing should be printed.
		// Note: you can test your code with a lower amount, too.
		System.out.println("\nQ8: Should print nothing: ");
		q8();
		
		// Q9: Find the sum of the numbers represented in an String array.
		String[] numWords = {"1", "2", "3", "4", "5", "6"};
		int sum = q9(numWords);
		System.out.println("\nQ9: Sum is 21: " + sum);
		
		// Q10: Create a String of the numbers represented in the array, separated by semicolons.
		Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String concat = q10(nums);
		System.out.println("\nQ10: Should print \n1;2;3;4;5;6;7;8;9;10 \n" + concat);
		
		// Q11: Create an infinite stream of random integers in the range 1-100.
		// Keep only the numbers that are multiples of 3.
		// Print the first 5 of these numbers.
		System.out.println("\nQ11: Should print 5 numbers that are multiples of 3 between 1-100:");
		q11();
		
		// Q12: Print the top 9-highest-scoring scrabble word in the list.
		// Note: a method is provided below to convert from char to score.
		// Hint: you might consider writing another method to find the score of a word!
		List<String> scrabbleWords = Files.readAllLines(Paths.get("words.txt"), Charset.forName("Cp1252"));
		System.out.println("\nQ12 Should print: " + "\n\tpizzazz worth 45 points"+"\n\tpizazz worth 35 points" +"\n\tjazzily worth 35 points" +
				"\n\tquizzed worth 35 points" + "\n\tjacuzzi worth 34 points" + "\n\tquizzer worth 34 points" +
				"\n\tquizzes worth 34 points" + "\n\tjazzy worth 33 points" + "\n\tjazzing worth 33 points" ); 
		q12(scrabbleWords);

	}
	
	public static long q1() {
		// Q1: How many customers in CA?
		return 0;
	}
	public static List<Customer> q2 () {
		// Q2: Create a list of all priority customers in MA.
		return new ArrayList<>();	
	}
	public static double q3() {
		// Q3: How much money have all customers spent (combined)?
		return 0;
	}
	public static double q4() {
		// Q4: How much money have all priority customers spent (combined)?
		return 0;
	}
	public static Map<String, Customer> q5() {
		// Q5: Create a map of all WY priority customers (key=id, value=customer)
		return new HashMap<>();
	}
	public static double q6() {
		// Q6: What is the greatest amount of money spent by a NY priority customer?
		return 0;
	}
	public static String q7() {
		//Q7: Find all customers that spent > 9000.
		return "";
	}
	public static void q8() {
		//Q8: Find any customer that has spent > 9800. 
		// Print the amount spent by the customer. If there is none, nothing should be printed.
		// Note: you can test your code with a lower amount, too.

	}
	public static int q9(String[] numWords) {
		// Q9: Find the sum of the numbers represented in an String array.
		return 0;
	}
	public static String q10(Integer[] nums) {
		// Q10: Create a String of the numbers represented in the array, separated by semicolons.
		return "";
	}
	public static void q11() {
		// Q11: Create an infinite stream of random integers in the range 1-100.
		// Keep only the numbers that are multiples of 3.
		// Print the first 10 of these numbers.
	}
	public static void q12(List<String> scrabbleWords) {
		// Q12: Print the top 9-highest-scoring scrabble word in the list.
		// Note: a method is provided below to convert from char to score.
		// Hint: you might consider writing another method to find the score of a word! 
	}
	
	public static int wordScore(String s) {
		char[] letters = s.toCharArray();
		int total = 0;
		for(char c : letters) {
			total += charToScore(c);
		}
		return total;
	}
	
	public static int charToScore(char c) {
		switch (c) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
			case 'n': case 'r': case 't': case 'l': case 's':
				return 1;
			case 'g': case 'd': 
				return 2;
			case 'b': case 'c': case 'm': case 'p': 
				return 3;	
			case 'f': case 'h': case 'v': case 'w': case 'y':
				return 4;	
			case 'k': 
				return 5;
			case 'j': case 'x': 
				return 8;
			case 'q': case 'z': 
				return 10;		
			default:
				return -1;
		}
	}
	
	public static void fillList(List<Customer> list) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File("Customers.csv")))) {

			
			while(fileScan.hasNext()) {
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String id = lineScan.next();
				String state = lineScan.next();
				boolean priority = Boolean.parseBoolean(lineScan.next());
				double amount = Double.parseDouble(lineScan.next());
				Customer c = new Customer(firstName, lastName, id, state, priority, amount);
				list.add(c);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}
