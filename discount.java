import java.util.Scanner;

public class hwk4_h {

	public static void main(String[] args){

		double num_of_packages = 0;
		double package_amnt = 50.00;
		double discount = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter the number of packages: ");
		num_of_packages = keyboard.nextDouble();

		double purchase_amnt = (num_of_packages * package_amnt);

		double discount_1 = ((purchase_amnt) * .20);
		double discount_2 = ((purchase_amnt) * .30);
		double discount_3 = ((purchase_amnt) * .40);
		double discount_4 = ((purchase_amnt) * .50);

		if(num_of_packages < 10){
			System.out.println("\nDiscount: " + discount + " \nPurchase amount after discount: " + (purchase_amnt));
		}
		else if(num_of_packages >= 10 && num_of_packages <= 19){
			System.out.println("\nDiscount: " + discount_1 + " \nPurchase amount after discount: " + (purchase_amnt - discount_1));
		}
		else if(num_of_packages >= 20 && num_of_packages <= 49){
			System.out.println("\nDiscount: " + discount_2 + " \nPurchase amount after discount: " + (purchase_amnt - discount_2));
		}
		else if(num_of_packages >= 50 && num_of_packages <= 99){
			System.out.println("\nDiscount: " + discount_3 + " \nPurchase amount after discount: " + (purchase_amnt - discount_3));
		}
		else if(num_of_packages >= 100){
			System.out.println("\nDiscount: " + discount_4 + " \nPurchase amount after discount: " + (purchase_amnt - discount_4));
		}
	}
}
