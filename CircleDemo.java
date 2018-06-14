//This program demonstrates the Circle class's setX, setY, getX, getY and getArea methods.

public class CircleDemo 
{

	public static void main(String[]args)
	{
		//Create a Circle object
		MyCircle circle = new MyCircle();

		//Set x to 10.0 and y to 20.0 and radius to 30.0
		circle.setX(10.0);
		circle.setY(20.0);
		circle.setRadius(30.0);
		circle.getArea();

		//Display x
		System.out.println("The circle's x is " + circle.getX());

		//Display y
		System.out.println("The circle's y is " + circle.getY());

		//Display radius
		System.out.println("The circle's radius is " + circle.getRadius());

		//Display area
		System.out.println("The circle's area is " + circle.getArea());
	}
}
