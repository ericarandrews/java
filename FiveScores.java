//The program compiles in the Terminal with five integers entered after filename
//i.e. java fiveScores 70 80 80 90 70
//Input range: 0 - 100

import java.util.Scanner;
public class FiveScores 
{
	Scanner input = new Scanner(System.in);		
	String [] args = {input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine()};
	
	public static void main (String[]args) 
	{		
		int [] array = new int [5];	
		int [] scores = new int [5];
		int grade = 0;
		
		setGrades(args, array);		
		
		for(int i = 0; i < 1; i++)
		{
			if((array[0] + array[1] + array[2] + array[3] + array[4]) != 0)	
			{
				System.out.print("\nYour score grades: " + determineGrade(array[0]));
				System.out.print(" " + determineGrade(array[1])); 
				System.out.print(" " + determineGrade(array[2]));
				System.out.print(" " + determineGrade(array[3]));
				System.out.print(" " + determineGrade(array[4]));
				
				grade = ((array[0] + array[1] + array[2] + array[3] + array[4])/5);
				
				System.out.print("\nYour final score and grade: " + calcAverage(array));
				System.out.print(" " + determineGrade(grade));
                                System.out.print("\n\n");
			}
		}
	}
	
	public static boolean setGrades(String args[], int [] array)
	{	
		
		Scanner input = new Scanner(System.in);
					
		int [] copyArray = new int [5];
		
		for(int i = 0; i < args.length; i++)
		{
			copyArray[i] = Integer.parseInt(args[i]);
		}
		
		for(int i = 0; i < array.length; i++)
		{
			if(copyArray[0] <= 100 && 
					copyArray[1] <= 100 && 
					copyArray[2] <= 100 && 
					copyArray[3] <= 100 && 
					copyArray[4] <= 100 && 
					copyArray[0] >= 0 && 
					copyArray[1] >= 0 && 
					copyArray[2] >= 0 && 
					copyArray[3] >= 0 && 
					copyArray[4] >= 0 && 
					array.length == args.length)
			{
				array[i] = copyArray[i];
			} 
		}
		return false;
	}
	
	public static double calcAverage(int [] scores)
	{
		double average = 0;
		double sum;
		sum = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]);
		average = (sum / scores.length);
		return average;
	}
	
	public static char determineGrade(int integer)
	{
		char letterGrade = 0;

		if(integer < 0 || integer <= 59)
		{
			letterGrade = 'F';
		}
		else if(integer < 60 || integer <= 69)
		{
			letterGrade = 'D';
		}
		else if(integer < 70 || integer <= 79)
		{
			letterGrade = 'C';
		}
		else if(integer < 80 || integer <= 89)
		{
			letterGrade = 'B';
		}
		else if(integer < 90 || integer <= 100)
		{
			letterGrade = 'A';
		}
		return letterGrade;
	}
}
