import java.util.Scanner;

public class ExceptionTester {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a positive number or 0: ");
			int number = Integer.parseInt(scan.nextLine());
			if (number < 0) {
				throw new NegativeNumberException();
			}
			System.out.println("Thank you!");
		} catch (NegativeNumberException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
