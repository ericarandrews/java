import java.util.Scanner;

public class HighScoresClassProgram 
{
	public static void main(String args[])
	{
		//Create an array to reference HighScoresClass objects
		HighScoresClass[] scores = new HighScoresClass[5];
		
		initialize(scores);
		display(scores);
	}

	public static void initialize(HighScoresClass[] scores)
	{
		Scanner input = new Scanner(System.in);	
		String name = null;
		int score = 0;
		int i;
				
		for(i = 0; i < scores.length; i++)
		{
		System.out.print("Only enter the Name for score# "+ (i+1) + ":");
		name = input.nextLine();
		scores[i] = new HighScoresClass(name,score);
		}
		
		for(i = 0; i < scores.length; i++)
		{
		System.out.print("Now enter the score# "+ (i+1) + " for "+ scores[i].getName() + ":");
		score = input.nextInt();
		name = scores[i].getName();
		scores[i] = new HighScoresClass(name,score);
		}	
	}
		
	public static void sort(HighScoresClass[] scores)
	{
		Scanner input = new Scanner(System.in);
		int index;
		
        	int first = 0;
		for(index = 0; index < scores.length; index++)
		{
			if(scores[index].getScore() > first)
			{
				first = scores[index].getScore();
			}
		}		
		if(first == scores[0].getScore())
		{
			System.out.println(scores[0].getName()+ ": "+first);
		}
		else if(first == scores[1].getScore())
		{
			System.out.println(scores[1].getName()+ ": "+first);
		}
		else if(first == scores[2].getScore())
		{
			System.out.println(scores[2].getName()+ ": "+first);
		}
		else if(first == scores[3].getScore())
		{
			System.out.println(scores[3].getName()+ ": "+first);
		}
		else if(first == scores[4].getScore())
		{
			System.out.println(scores[4].getName()+ ": "+first);
		}
	
		int second = 0;
		for(index = 0; index < scores.length; index++)
		{
			if(scores[index].getScore() < first && scores[index].getScore() > second)
			{
				second = scores[index].getScore();
			}	
		}
		if(second == scores[0].getScore())
		{
			System.out.println(scores[0].getName()+ ": "+second);
		}
		else if(second == scores[1].getScore())
		{
			System.out.println(scores[1].getName()+ ": "+second);
		}
		else if(second == scores[2].getScore())
		{
			System.out.println(scores[2].getName()+ ": "+second);
		}
		else if(second == scores[3].getScore())
		{
			System.out.println(scores[3].getName()+ ": "+second);
		}
		else if(second == scores[4].getScore())
		{
			System.out.println(scores[4].getName()+ ": "+second);
		}

		int third = 0;
		for(index = 0; index < scores.length; index++)
		{
			if(scores[index].getScore() < second && scores[index].getScore() > third)
			{
				third = scores[index].getScore();
			}
		}
		if(third == scores[0].getScore())
		{
			System.out.println(scores[0].getName()+ ": "+third);
		}
		else if(third == scores[1].getScore())
		{
			System.out.println(scores[1].getName()+ ": "+third);
		}
		else if(third == scores[2].getScore())
		{
			System.out.println(scores[2].getName()+ ": "+third);
		}
		else if(third == scores[3].getScore())
		{
			System.out.println(scores[3].getName()+ ": "+third);
		}
		else if(third == scores[4].getScore())
		{
			System.out.println(scores[4].getName()+ ": "+third);
		}	
		
		int fourth = 0;
		for(index = 0; index < scores.length; index++)
		{
			if(scores[index].getScore() < third && scores[index].getScore() > fourth)
			{
				fourth = scores[index].getScore();
			}
		}		
		if(fourth == scores[0].getScore())
		{
			System.out.println(scores[0].getName()+ ": "+fourth);
		}
		else if(fourth == scores[1].getScore())
		{
			System.out.println(scores[1].getName()+ ": "+fourth);
		}
		else if(fourth == scores[2].getScore())
		{
			System.out.println(scores[2].getName()+ ": "+fourth);
		}
		else if(fourth == scores[3].getScore())
		{
			System.out.println(scores[3].getName()+ ": "+fourth);
		}
		else if(fourth == scores[4].getScore())
		{
			System.out.println(scores[4].getName()+ ": "+fourth);
		}
		
		int fifth = 0;
		for(index = 0; index < scores.length; index++)
		{
			if(scores[index].getScore() < fourth && scores[index].getScore() > fifth)
			{
				fifth = scores[index].getScore();
			}
		}
		if(fifth == scores[0].getScore())
		{
			System.out.println(scores[0].getName()+ ": "+fifth);
		}
		else if(fifth == scores[1].getScore())
		{
			System.out.println(scores[1].getName()+ ": "+fifth);
		}
		else if(fifth == scores[2].getScore())
		{
			System.out.println(scores[2].getName()+ ": "+fifth);
		}
		else if(fifth == scores[3].getScore())
		{
			System.out.println(scores[3].getName()+ ": "+fifth);
		}
		else if(fifth == scores[4].getScore())
		{
			System.out.println(scores[4].getName()+ ": "+fifth);
		}	
	}

	public static void display(HighScoresClass[] scores)
	{
		System.out.println("\nTop Scorers:");
		sort(scores);
	}
}
//If there are duplicate scores entered, the first score entry will be displayed.

