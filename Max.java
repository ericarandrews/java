
import java.util.Scanner;

public class Max 
{
	
	public static void main(String [] args) 
	{
	
	Scanner keyboard = new Scanner(System.in);

	int num_of_salespersons;
	System.out.print("Enter the number of sales persons: ");
	num_of_salespersons = keyboard.nextInt();

	if(num_of_salespersons == 0)
	{
		System.out.println("\nSince salespersons = " + num_of_salespersons + ", there are no winners of this contest.");
	}
	else 
	{	
	
	int num_of_units_sold = 0;
	int largest_value = 0;
	
	int i;
	int winner = 0;

	int tied_value = 0;
	int tied_winner = 0;
	
	for(i = 1; i <= num_of_salespersons; i++) 
	{
	System.out.print("Enter the number of units sold for sales person #" + i + ": ");
	num_of_units_sold = keyboard.nextInt();		
		
	if(num_of_units_sold > largest_value) 
	{
		tied_value = largest_value;
		tied_winner = winner;

		winner = i;
		largest_value = num_of_units_sold;	
	}
	
	else if(num_of_units_sold > tied_value) 
	{
		tied_value = num_of_units_sold;
		tied_winner = i;
	}
			
	}
	
	System.out.println("\nThe winner of the sales contest: Sales Person #" + winner +  ". \nNumber of units sold: " + largest_value);
		
		if(tied_value == largest_value)
		{
			System.out.println("\nThe 2nd winner of the sales contest: Sales Person #" + tied_winner + ". \nNumber of units sold: " + tied_value);
		}
	}
}
}	
