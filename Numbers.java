import java.util.Scanner;

public class Numbers{

	public static void main(String[] args){

		double num_one = 0;
		double num_two = 0;
		double num_three = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter number one: ");
		num_one = keyboard.nextDouble();
		System.out.print("Enter number two: ");
		num_two = keyboard.nextDouble();
		System.out.print("Enter number three: ");
		num_three = keyboard.nextDouble();


		if(num_one == num_two && num_two == num_three){
			System.out.println("All numbers are equal.");
		}


		if(num_one == num_two && num_one > num_three) {
			System.out.print("\nLargest numbers to smallest numbers: ");
			System.out.print("\nNumber one: \n" + num_one);
			System.out.print("\nNumber two: \n" + num_two);
			System.out.println("\nNumber three: \n" + num_three);
		}
		else if(num_one == num_two && num_one < num_three) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber three: \n" + num_three);
				System.out.print("\nNumber one: \n" + num_one);
				System.out.println("\nNumber two: \n" + num_two);
		}


		if(num_one == num_three && num_one > num_two) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber one: \n" + num_one);
				System.out.print("\nNumber three: \n" + num_three);
				System.out.println("\nNumber two: \n" + num_two);
		}
		else if(num_one == num_three && num_one < num_two) {
					System.out.print("\nLargest numbers to smallest numbers: ");
					System.out.print("\nNumber two: \n" + num_two);
					System.out.print("\nNumber one: \n" + num_one);
					System.out.println("\nNumber three: \n" + num_three);
		}


		if(num_two == num_three && num_two > num_one) {
			System.out.print("\nLargest numbers to smallest numbers: ");
			System.out.print("\nNumber two: \n" + num_two);
			System.out.print("\nNumber three: \n" + num_three);
			System.out.println("\nNumber one: \n" + num_one);
		}
		else if(num_two == num_three && num_two < num_one) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber one: \n" + num_one);
				System.out.print("\nNumber two: \n" + num_two);
				System.out.println("\nNumber three: \n" + num_three);
		}


		if((num_one > num_two && num_one > num_three) && (num_two > num_three)) {
			System.out.print("\nLargest numbers to smallest numbers: ");
			System.out.print("\nNumber one: \n" + num_one);
			System.out.print("\nNumber two: \n" + num_two);
			System.out.println("\nNumber three: \n" + num_three);
			}
			else if((num_one > num_two && num_one > num_three) && (num_two < num_three)) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber one: \n" + num_one);
				System.out.print("\nNumber three: \n" + num_three);
				System.out.println("\nNumber two: \n" + num_two);
			}


		if((num_two > num_three && num_two > num_one) && (num_one > num_three)) {
			System.out.print("\nLargest numbers to smallest numbers: ");
			System.out.print("\nNumber two: \n" + num_two);
			System.out.print("\nNumber one: \n" + num_one);
			System.out.println("\nNumber three: \n" + num_three);
		}
			else if((num_two > num_three && num_two > num_one) && (num_one < num_three)) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber two: \n" + num_two);
				System.out.print("\nNumber three: \n" + num_three);
				System.out.println("\nNumber one: \n" + num_one);
			}


		if((num_three > num_two && num_three > num_one) && (num_two > num_one)) {
			System.out.print("\nLargest numbers to smallest numbers: ");
			System.out.print("\nNumber three: \n" + num_three);
			System.out.print("\nNumber two: \n" + num_two);
			System.out.println("\nNumber one: \n" + num_one);
		}
			else if((num_three > num_two && num_three > num_one) && (num_two < num_one)) {
				System.out.print("\nLargest numbers to smallest numbers: ");
				System.out.print("\nNumber three: \n" + num_three);
				System.out.print("\nNumber one: \n" + num_one);
				System.out.println("\nNumber two: \n" + num_two);
			}


		}
	}
