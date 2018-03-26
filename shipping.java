import java.util.Scanner;

public class Shipping {

	public static void main(String[] args){

		double weight_of_package = 0;
		double distance = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter weight of package: ");
		weight_of_package = keyboard.nextDouble();
		System.out.print("Enter distance: ");
		distance = keyboard.nextDouble();

		double rate_1 = 1.10;
		double rate_2 = 2.10;
		double rate_3 = 3.10;
		double rate_4 = 4.00;


if(weight_of_package <= 2){
	if(distance <= 500){
		System.out.println("Shipping Charge: " + ((distance * rate_1) / 500));
	}
	else if(distance > 500 && distance <= 1000){
		System.out.println("Shipping Charge: " + ((((distance - 500) * rate_1) / 500) + (rate_1)));
	}
	else if(distance > 1000 && distance <= 1500){
		System.out.println("Shipping Charge: " + ((((distance - 1000) * rate_1) / 500) + (rate_1 * 2)));
	}
}


if(weight_of_package > 2 && weight_of_package <= 6){
	if(distance <= 500){
		System.out.println("Shipping Charge: " + ((distance * rate_2 ) / 500));
	}
	else if(distance > 500 && distance <= 1000){
		System.out.println("Shipping Charge: " + ((((distance - 500) * rate_2 ) / 500) + (rate_2)));
	}
	else if(distance > 1000 && distance <= 1500){
		System.out.println("Shipping Charge: " + ((((distance - 1000) * rate_2) / 500) + (rate_2 * 2)));
	}
}


if(weight_of_package > 6 && weight_of_package <= 10){
	if(distance <= 500){
		System.out.println("Shipping Charge: " + ((distance * rate_3) / 500));
	}
	else if(distance > 500 && distance <= 1000){
		System.out.println("Shipping Charge: " + ((((distance - 500) * rate_3) / 500) + (rate_3)));
	}
	else if(distance > 1000 && distance <= 1500){
		System.out.println("Shipping Charge: " + ((((distance - 1000) * rate_3) / 500) + (rate_3 * 2)));
	}
}


if(weight_of_package > 10){
	if(distance <= 500){
		System.out.println("Shipping Charge: " + (((distance * rate_4 ) / 500)));
	}
	else if(distance > 500 && distance <= 1000){
		System.out.println("Shipping Charge: " + (((((distance - 500) * rate_4 ) / 500) + (rate_4))));
	}
	else if(distance > 1000 && distance <= 1500){
		System.out.println("Shipping Charge: " + ((((distance - 1000) * rate_4) / 500) + (rate_4 * 2)));
	}
}
	}
}
