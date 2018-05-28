import java.util.Scanner;

public class Credit 
{
	public static void main(String[] args)
	{

	double beginning_balance = 0;
	double new_charges = 0;
	double credits = 0;
	double credit_limit = 0;

	Scanner keyboard = new Scanner(System.in);

	System.out.print("Enter beginning balance: ");
	beginning_balance = keyboard.nextDouble();
	System.out.print("Enter new charges: ");
	new_charges = keyboard.nextDouble();
	System.out.print("Enter credits: ");
	credits = keyboard.nextDouble();
	System.out.print("Enter credit limit: ");
	credit_limit = keyboard.nextDouble();

	double new_balance;

	if (credits > new_charges){
		new_balance = (beginning_balance - (credits - new_charges));
		}
	else{
		new_balance = (beginning_balance + (new_charges - credits));
		};

	if (new_balance == 0){
			System.out.println("No Payment Due. New balance = " + new_balance);
	}
	else if(new_balance < 0){
			System.out.println("No Payment Due. New balance = " + new_balance);
	}
	else if(new_balance > credit_limit){
		System.out.println("Credit limit exceeded. New balance = " + new_balance);
	}
	else if(new_balance <= credit_limit){
		System.out.println("New balance = " + new_balance);
	}

	}
	}
