//This program is a revision of the Number_Guesser class with added arguments
//This program demonstrates the Number_Guesser class's lower method and higher method
public class lowAndhighDemo {

	public static void main(String[]args)
	{

		//Create a Number_Guesser object and assign its address to the guesser variable
		//Number_Guesser guesser = new Number_Guesser();

		//Create a lowAndHighReturnMethod object and assign its address to the addedMethods variable
	    lowAndHighReturnMethod addedMethods = new lowAndHighReturnMethod();	


			//Call the object's lower method, passing 100 as an argument.
			//guesser.lower(100);

			//Call the object's lower method, passing 100 as an argument.
			addedMethods.lower(100);

			//Call the object's higher method, passing 1 as an argument.
			//guesser.higher(1);

			//Call the object's higher method, passing 1 as an argument.
			addedMethods.higher(1);


				//Indicate what we are doing
				System.out.println("Sending the value 100 " + "to the lower method.");
				System.out.println("Sending the value 1 " + "to the higher method.");


				//Indicate we are done
				System.out.println("Done");
				System.out.println("Done");
	}
}
