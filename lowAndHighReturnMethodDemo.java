//This program is a revision of the Number_Guessing_withaClass with added arguments
//This program demonstrates the lowAndHighReturnMethod class's getLower method and getHigher method
public class lowAndHighReturnMethodDemo
{
	public static void main(String[]args)
	{
		//Create a lowAndHighReturnMethod object and assign its address to the addedMethods variable
		lowAndHighReturnMethod addedMethods = new lowAndHighReturnMethod();
		
		//Call the object's lower method, passing 100 as an argument.
		addedMethods.lower(100);
		
		//Call the objects higher method, passing 1 as an argument. 
		addedMethods.higher(1);
		
		//Display the object's getLower and getHigher methods and getCurrentGuess method
		System.out.println("The high value is " + addedMethods.getLower());
		System.out.println("The low value is " + addedMethods.getHigher());
		System.out.println("The mid value is " + addedMethods.getCurrentGuess());
		}
}
