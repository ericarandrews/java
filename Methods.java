import java.util.Scanner;
public class Methods
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		double wholesale_cost = 0;
		double markup_percentage = 0;
		double retail_price = 0;
		double total_retail_costs = 0;
		
		while(wholesale_cost != -1)
		{
			System.out.println("\nEnter item's wholesale cost or enter -1 to stop: ");
			wholesale_cost = input.nextDouble();
			
			if(wholesale_cost != -1)
			{
				System.out.println("Enter item's markup percentage (i.e. enter '100' for 100%): ");
				markup_percentage = input.nextDouble();
				markup_percentage = (markup_percentage/100);
				retail_price = calculateRetail(wholesale_cost, markup_percentage);
				System.out.println("The item's retail price: " + retail_price);
				total_retail_costs = total_retail_costs + retail_price;
			}
		}
		
		System.out.println("\nThe total retail cost of all items: " + total_retail_costs);
	}
	
	public static double calculateRetail(double wholesale_cost, double markup_percentage)
	{
		double retail_price;
		retail_price = wholesale_cost + (wholesale_cost * markup_percentage);
		return retail_price;
	}
	//Enter values 5.00, 100, 5.00, 50 and -1; Output should be 10.0, 7.5, and 17.5;
	//Enter values 5.00, 20, -5.00, 0 and -1; Output should be 6.0, -5.0, and 1.0;
}

