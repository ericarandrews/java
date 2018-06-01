import java.util.Scanner;
public class If
{
	public static void main(String args[])
	{
		int one;
		int two;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		one = input.nextInt();
		System.out.print("Enter another number: ");
		two = input.nextInt();
		
		if(one == two)
		{
			System.out.println("The numbers entered are equal.");
		}
		
		if(one != two)
		{
			int multiple = one % two;
			
			if(multiple == 0)
			{
				System.out.println("The first number entered is a multiple of the second number entered");
			}
			else
			{
				System.out.println("The first number entered is not a multiple of the second number entered");
			}
		}
		//Enter values 9 and 3; Output should be 'The first number entered is a multiple of the second number entered';
		//Enter values 4 and 3; Output should be 'The first number entered is not a multiple of the second number entered';
		//Enter values 3 and 9; Output should be 'The first number entered is not a multiple of the second number entered';
		//Enter values 3 and 3; Output should be 'The numbers entered are equal.';
	}
}

