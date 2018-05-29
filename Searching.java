import java.util.Scanner;
public class Searching
{
	public static void main(String args[])
	{
		int[]a = new int[5];
		int newValue = 0;
		int numberUnique = 0;
		
		array(a);
		addIfUnique(a, newValue, numberUnique);
	}	
	
	public static void array(int[]a)
	{
		System.out.println("Enter 5 numbers between 10 and 100.");
		System.out.println("Only unique values will display...\n");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Input first number: ");
		a[0] = input.nextInt();
		System.out.print("Input second number: ");
		a[1] = input.nextInt();
		System.out.print("Input third number: ");
		a[2] = input.nextInt();
		System.out.print("Input fourth number: ");
		a[3] = input.nextInt();
		System.out.print("Input fifth number: ");
		a[4] = input.nextInt();
	}
	
	public static int addIfUnique(int[]a, int newValue, int numberUnique)
	{
		numberUnique = 5;
		newValue = 0;
		
		for(int i = 0; i < numberUnique; i++)
		{
			if(a[0] == a[i] && i != 0)
			{
				a[i] = 0;
			}
		}
		
		for(int i = 0; i < numberUnique; i++)
		{
			if(a[1] == a[i] && i != 0 && i != 1)
			{
				a[i] = 0;
			}
		}
		
		for(int i = 0; i < numberUnique; i++)
		{
			if(a[2] == a[i] && i != 0 && i != 1 && i != 2)
			{
				a[i] = 0;
			}
		}
		
		for(int i = 0; i < numberUnique; i++)
		{
			if(a[3] == a[i] && i != 0 && i != 1 && i != 2 && i != 3)
			{
				a[i] = 0;
			}
		}
		
		for(int i = 0; i < numberUnique; i++)
		{
			if(a[i] > 0)
			{
				a[i] = a[i];
				a[newValue] = a[i];
				newValue++;
			}
		}
		
		System.out.print("\n");
		numberUnique = newValue;
		
		for(int i = 0; i < numberUnique; i++)
		{
			System.out.println("Unique value entered: " + a[i]); 
		}
		
		return numberUnique;
	}
	//Enter values 10, 20, 30, 40 and 50; Output should be 10, 20, 30, 40 and 50;
	//Enter values 10, 20, 30, 20 and 10; Output should be 10, 30 and 20;
	//Enter values 10, 10, 10, 10 and 10; Output should be 10;	
}

