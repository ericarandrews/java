import java.util.*;

public class IceCreamShop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Ice Cream Shop!");
		
		System.out.println("How many orders will you place today?");
		int numOrders = Integer.parseInt(scan.nextLine());
		List<IceCreamOrder> iceCreamOrderList = new ArrayList<IceCreamOrder>();

		for(int i=0; i<numOrders; i++) {
			System.out.println("Order " + (i+1));
			System.out.println("Is this order allowed to contain nuts? y/n");
			String nutsString = scan.nextLine();
			boolean orderAllowedToHaveNuts = nutsString.equalsIgnoreCase("y");
			
			System.out.println("Here are your flavor choices:");
			Flavor[] flavorChoices = Flavor.values();
			for(Flavor flavorChoice : flavorChoices) {
				boolean flavorHasNuts = !flavorChoice.isNutFree();
				
				if(orderAllowedToHaveNuts || (!orderAllowedToHaveNuts && !flavorHasNuts)) {
					System.out.println(flavorChoice.ordinal() + ". " + flavorChoice);
				}
			}
			System.out.println("Enter the flavor number.");
			int flavorNumber = Integer.parseInt(scan.nextLine());
			
			System.out.println("How many scoops?");
			int scoops = Integer.parseInt(scan.nextLine());
			
			IceCreamOrder order = new IceCreamOrder(scoops, Flavor.values()[flavorNumber]);
			// second parameter is equivalent to:
			//Flavor[] flavors = Flavor.values();
			//Flavor flavor = flavors[flavorNumer];
			
			iceCreamOrderList.add(order);
			
			
		}
		
		System.out.println("Thank you for your order. Here is your summary:");
		System.out.println(iceCreamOrderList);
		System.out.println("You ordered a total of " + IceCreamOrder.getTotalNumberScoops() + " scoops.");
		System.out.println("Good-bye.");
		
	}

}
