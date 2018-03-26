
import java.util.Scanner;

public class LastRecordCheck
{
	public static void main(String [] args)
	{
	    int exam_score;
	    int number_of_scores = 0;

	    Scanner keyboard = new Scanner(System.in);
	    System.out.print("Enter exam score or -1 to end: ");
	    exam_score = keyboard.nextInt();

	    int largest_score = 0;
	    int smallest_score = 999999999;

	    while(exam_score != -1)
	    {
	        number_of_scores++;

	        if(exam_score > largest_score)
	        {
	          largest_score = exam_score;
	        }
	        if(exam_score < smallest_score)
	        {
	          smallest_score = exam_score;
	        } 
	        System.out.print("Enter exam score or -1 to end: ");
	        exam_score = keyboard.nextInt();
	    }
	    System.out.println("\nThe number of scores entered: " + number_of_scores);
	    System.out.println("Largest score: " + largest_score);
	    System.out.println("Smallest score: " + smallest_score);
	}
}
