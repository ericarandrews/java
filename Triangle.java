import java.util.Scanner;


public class Triangle 
{
	public static void main(String[] args)
	{

	int side_one;
	int side_two;
	int side_three;

	Scanner keyboard = new Scanner(System.in);

	System.out.print("Enter side one: ");
	side_one = keyboard.nextInt();
	System.out.print("Enter side two: ");
	side_two = keyboard.nextInt();
	System.out.print("Enter side three: ");
	side_three = keyboard.nextInt();


	if(side_one == side_two && side_one == side_three)
	{
	 	if(side_one == 0 || side_two == 0 || side_three == 0)
		{
		System.out.println("\nSides cannot form a triangle.");
		}
		else
		{
		System.out.println("\nSides can form a triangle.");
		}
	}


	int sum_of_side_oneAndtwo = side_one + side_two;
	int sum_of_side_twoAndthree = side_two + side_three;
	int sum_of_side_threeAndone = side_three + side_one;


	if((side_one > side_two && side_one > side_three))
	{
		if(side_one < sum_of_side_twoAndthree)
		{
		System.out.println("\nSides can form a triangle.");
		}
		else
		{
		System.out.println("\nSides cannot form a triangle.");
		}
	}
	if((side_one > side_two && side_one > side_three))
	{
		if((side_one * side_one) == ((side_two * side_two) + (side_three * side_three)))
		{
		System.out.println("According to Pythagoras's Theorem, these sides form a right triangle.");
		}
	}


	if((side_two > side_three && side_two > side_one))
	{
		if(side_two < sum_of_side_threeAndone)
		{
		System.out.println("\nSides can form a triangle.");
		}
		else
		{
		System.out.println("\nSides cannot form a triangle.");
		}
	}
	if((side_two > side_three && side_two > side_one))
	{
		if((side_two * side_two) == ((side_three * side_three) + (side_one * side_one)))
		{
		System.out.println("According to Pythagoras's Theorem, these sides form a right triangle.");
		}
	}


	if((side_three > side_one && side_three > side_two))
	{
		if(side_three < sum_of_side_oneAndtwo)
		{
		System.out.println("\nSides can form a triangle.");
		}
		else
		{
		System.out.println("\nSides cannot form a triangle.");
		}
	}
	if((side_three > side_one && side_three > side_two))
	{
		if((side_three * side_three) == ((side_one * side_one) + (side_two * side_two)))
		{
		System.out.println("According to Pythagoras's Theorem, these sides form a right triangle.");
		}
	}
    }
}
