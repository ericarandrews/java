import java.util.Scanner;

public class Roman {

	public static void main(String[] args){
	int numbers;

	Scanner keyboard = new Scanner(System.in);

	System.out.println("Enter a number within the range of 1 through 10: ");
	numbers = keyboard.nextInt();

	if(numbers > 10 || numbers < 1){
		System.out.println("Error message: Number entered is outside the range of 1 through 10.");
	}
	else {
		if(numbers == 1){
			System.out.println("Roman numeral: I ");
		}
		else if(numbers == 2){
			System.out.println("Roman numeral: II ");
		}
		else if(numbers == 3){
			System.out.println("Roman numeral: III ");
		}
		else if(numbers == 4){
			System.out.println("Roman numeral: IV ");
		}
		else if(numbers == 5){
			System.out.println("Roman numeral: V ");
		}
		else if(numbers == 6){
			System.out.println("Roman numeral: VI ");
		}
		else if(numbers == 7){
			System.out.println("Roman numeral: VII ");
		}
		else if(numbers == 8){
			System.out.println("Roman numeral: VIII ");
		}
		else if(numbers == 9){
			System.out.println("Roman numeral: IX ");
		}
		else if(numbers == 10){
			System.out.println("Roman numeral: X ");

		}
	}


	}
}
