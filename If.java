
import java.util.Scanner;


public class If 
{
	public static void main(String[] args)
	{
		int integer_one = 0;
		int integer_two = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter the value of integer one: ");
		integer_one = keyboard.nextInt();
		System.out.print("Enter the value of integer two: ");
		integer_two = keyboard.nextInt();


		if(integer_two == integer_one) 
		{
			System.out.println("The numbers are equal. Integer one = Integer two.");
		}
		else if(integer_two % integer_one == 0)
		{
			System.out.println("Integer one is a multiple of Integer two.");
			}
		else 
		{
			System.out.println("Integer one is not multiple of Integer two.");
		}
	}
}
