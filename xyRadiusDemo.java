//This program demonstrates the Circle class's setX, setY, radius, getX, getY, and getRadius methods.
public class xyRadiusDemo 
{

	public static void main(String[]args)
	{
		//Create a Circle object
		MyCircle circle = new MyCircle();

		//Call the object's setX method, passing 10.0
		//as an argument.
		circle.setX(10.0);

		//Call the object's setY method, passing 20.0
		//as an argument.
		circle.setY(20.0);

		//Call the object's setRadius method, passing 30.0
		//as an argument.
		circle.setRadius(30.0);

		//Display the object's x and y and radius.
		System.out.println("The x value is " + circle.getX());
		System.out.println("The y value is " + circle.getY());
		System.out.println("The radius value is " + circle.getRadius());

	}
}
