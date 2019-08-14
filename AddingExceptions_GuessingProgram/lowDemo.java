//This program is a revision of the Number_Guesser class with added arguments
//This program demonstrates the Number_Guesser class's lower method 
public class lowDemo {

	public static void main(String[]args)
	{

		//Create a Number_Guesser object and assign its address to the guesser variable
		//Number_Guesser guesser = new Number_Guesser();

		//Create a lowAndHighReturnMethod object and assign its address to the addedMethods variable
	    lowAndHighReturnMethod addedMethods = new lowAndHighReturnMethod();

			//Indicate what we are doing
			System.out.println("Sending the value 100 " + "to the low method.");

			//Call the box object's lower method.
			//guesser.lower(100);

			//Call the object's lower method.
			addedMethods.lower(100);


				//Indicate we are done
				System.out.println("Done.");
	}
}



