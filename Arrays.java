import java.util.Scanner;
public class Arrays
{
	public static void main(String args[])
	{
		int testing[] = new int[4];
		int cipher[] = new int[4];
		
		System.out.println("\nInput a cipher of 4 integers " + "to encrypt the word 'code'.");
		cipher(cipher);
		code(testing, cipher);
	}	
	
	public static void cipher(int cipher[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		cipher[0] = input.nextInt();
		System.out.print("Enter second integer: ");
		cipher[1] = input.nextInt();
		System.out.print("Enter third integer: ");
		cipher[2] = input.nextInt();
		System.out.print("Enter fourth integer: ");
		cipher[3] = input.nextInt();
	}
	
	public static void code(int testing[], int cipher[])
	{
		char code[] = new char[4];
		
		code[0] = 'c';
		code[1] = 'o';
		code[2] = 'd';
		code[3] = 'e';
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nTesting cipher...");
		System.out.print("Input first integer: ");
		testing[0] = input.nextInt();
		System.out.print("Input second integer: ");
		testing[1] = input.nextInt();
		System.out.print("Input third integer: ");
		testing[2] = input.nextInt();
		System.out.print("Input fourth integer: ");
		testing[3] = input.nextInt();
		System.out.print("\n");
		
		int index = 0;
		
		for(int i = 0; i < code.length; i++)
		{
			if(testing[0] == cipher[i])
			{
				index = i;
				System.out.println(code[i]);
			}
		}
		if(testing[0] != cipher[index])
		{
			System.out.println("Integer does not match any " + 
								"integer input for 'code' encrypted");
		}
		
		for(int i = 0; i < code.length; i++)
		{
			if(testing[1] == cipher[i])
			{
				index = i;
				System.out.println(code[i]);
			}
		}
		if(testing[1] != cipher[index])
		{
			System.out.println("Integer does not match any " + 
								"integer input for 'code' encrypted");
		}
		
		for(int i = 0; i < code.length; i++)
		{
			if(testing[2] == cipher[i])
			{
				index = i;
				System.out.println(code[i]);
			}
		}
		if(testing[2] != cipher[index])
		{
			System.out.println("Integer does not match any " + 
								"integer input for 'code' encrypted");
		}
		
		for(int i = 0; i < code.length; i++)
		{
			if(testing[3] == cipher[i])
			{
				index = i;
				System.out.println(code[i]);
			}
		}
		if(testing[3] != cipher[index])
		{
			System.out.println("Integer does not match any " +
								"integer input for 'code' encrypted");
		}
	}
	//Enter values 1,4,2, and 3 and 1,4,2 and 3; Output should be 'c','o','d' and 'e';
	//Enter values 1,4,2, and 3 and 2,3,4 and 1; Output should be 'd','e','o', and 'c';
	//Enter values 1,2,3, and 4 and 5,6,7 and 8; Output should be 'Integer does not match any integer input for 'code' encrypted';
}

