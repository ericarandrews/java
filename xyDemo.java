//This program demonstrates the Circle class's setX, setY, getX and getY methods.
public class xyDemo 
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

		//Display the object's x and y.
		System.out.println("The x value is " + circle.getX());

		System.out.println("The y value is " + circle.getY());
	}
}
