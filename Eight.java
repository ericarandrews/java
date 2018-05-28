import java.util.Scanner;

public class Eight
{
	public static void main(String args[])
  {	
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number of customers: ");
		int customers = keyboard.nextInt();
		double hours = 0;
		double charges = 0;
		double running_total = 0;
		int i = 0;

		for(i = 1; i <= customers; i++)
		{
			System.out.print("\nEnter the number of hours parked for customer #" + i + ": ");
			hours = keyboard.nextDouble();
			charges = calculateCharges(hours);
			running_total += charges;
			System.out.print("The charge for customer #" + i + ": $" + charges + "\n");
		}
		
		System.out.print("\nThe running total of the day: $" + running_total);
	}
	
	public static double calculateCharges(double customer_hours)
	{
		double charge = 0;
		
		if(customer_hours <= 3)
		{
			charge = 2.00;
		}
		if(customer_hours > 3 && customer_hours <= 19)
		{
			charge = 2.00 + (.50 * (customer_hours - 3));
		}
		if(customer_hours > 19 && customer_hours <= 24)
		{
			charge = 10.00;
		}
		return charge;
	}
	//Enter value 7 for customers and values 1, 2, 3, 4, 18, 19 and 24 for hours; Output should be 2.0, 2.0, 2.0, 2.5, 9.5, 10.0 and 10.0 for charge and 38.0 for running total;
}

