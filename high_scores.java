import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class high_scores {

//Write a program that records high-score data for a fictitious game. 
//The program will ask the user to enter five names, and five scores. 
//It will store the data in memory, and print it back out sorted by score.

	//array lists declared and initialized in main method; invoke other three methods
	public static void main(String args []) 
	{

		//creating an arraylist with names
		ArrayList<String> names = new ArrayList<String>();
		
		//creating an arraylist with scores
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		//invoke other three methods
		initialize(names, scores);
		sort(names, scores);
		display(names, scores);
		
	}

	//user input of five names and five scores; 
	public static void initialize(ArrayList<String> names, ArrayList<Integer> scores)
	{

		//for user input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the name for score # 1: ");
		names.add(keyboard.next());
		System.out.print("Enter the score for score # 1: ");
		scores.add(keyboard.nextInt());
		
		System.out.print("Enter the name for score # 2: ");
		names.add(keyboard.next());
		System.out.print("Enter the score for score # 2: ");
		scores.add(keyboard.nextInt());

		System.out.print("Enter the name for score # 3: ");
		names.add(keyboard.next());
		System.out.print("Enter the score for score # 3: ");
		scores.add(keyboard.nextInt());

		System.out.print("Enter the name for score # 4: ");
		names.add(keyboard.next());
		System.out.print("Enter the score for score # 4: ");
		scores.add(keyboard.nextInt());

		System.out.print("Enter the name for score # 5: ");
		names.add(keyboard.next());
		System.out.print("Enter the score for score # 5: ");
		scores.add(keyboard.nextInt());

	}


	//function sorts both array lists based on values in scores array list
	public static void sort(ArrayList<String> names, ArrayList<Integer> scores)
	{

			String array_names[] =  new String[names.size()];
			for(int x = 0; x < names.size(); x++) {
				array_names[x] = names.get(x);
			} 
		
			Integer array_scores[] = new Integer[scores.size()];
			for(int y = 0; y < scores.size(); y++) {
				array_scores[y] = scores.get(y);
			}
	}
	

	//method that displays the contents of the two arraylists
	public static void display(ArrayList<String> names, ArrayList<Integer> scores)
	{	
			
		String array_names[] =  new String[names.size()];
		for(int x = 0; x < names.size(); x++) {
			array_names[x] = names.get(x);		
		} 

		Integer array_scores[] = new Integer[scores.size()];
		for(int y = 0; y < scores.size(); y++) {
			array_scores[y] = scores.get(y);
			
		}
			
			Arrays.sort(array_scores);
		
		System.out.println(array_names[4] + " : " + array_scores[4]);
		System.out.println(array_names[3] + " : " + array_scores[3]);
		System.out.println(array_names[2] + " : " + array_scores[2]);
		System.out.println(array_names[1] + " : " + array_scores[1]);
		System.out.println(array_names[0] + " : " + array_scores[0]);
				
	}
}

