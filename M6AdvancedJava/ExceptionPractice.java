import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionPractice {

	public static void main(String[] args) {
			
		try {
			//readInput();
			loopingReadInput();
		} catch (InputMismatchException ex) {
			System.out.println("Back in main. That was not a number!");
		}
		System.out.println("Goodbye from main");
	}

	public static void loopingReadInput() {
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;
		while (!validInput) {
			try {
				System.out.println("Enter a positive number:");
				int number = Integer.parseInt(scan.nextLine());
				if (number > 0) {
					System.out.println("Yes! It's positive.");
				} else {
					System.out.println("Sorry, that number is not positive.");
				}
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("Hey, that is not a number! Try again.");
			}
		}
	}

	public static void readInput() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter a positive number:");
			// int number = Integer.parseInt(scan.nextLine());
			int number = scan.nextInt();

			System.out.println("I read that number.");
			if (number > 0) {
				System.out.println("Yes! It's positive.");
			} else {
				System.out.println("Sorry, that number is not positive.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Hey, that is not a number!");
			// System.out.println(ex.getMessage());
			// ex.printStackTrace();
		}
		System.out.println("Goodbye.");
	}

}
