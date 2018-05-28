import java.util.Scanner;

public class Average 
{	
	public static void main(String args [])
	{
		
		Scanner keyboard = new Scanner(System.in);
		int values;
		System.out.println("Enter number of values: ");
		values = keyboard.nextInt();
		
		if(values == 0) 
		{
			System.out.println("Average: " + values);
		}
		
		double total = 0;
		int x = 0;
	
		while(values != 0 && x < values)
		{
			for(x = 1; x < values + 1; x++)
			{
				double value_total;
				System.out.println("Enter value total for value #" + x + ": ");
				value_total = keyboard.nextDouble();
				
				total = total + value_total;
			}
			double percentage = (total / values) * 10;
			System.out.println("Average: " + (int)percentage);
		}
	}
}
