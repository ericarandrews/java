import java.util.Scanner;

public class CircleTester {
	
	public static void main(String[]args)
	{
		
		Circle c = new Circle(new Point(10,20),48);
		Circle center = new Circle(new Point(15,30),40);
		
		System.out.println("Center coordinates: " + c.getCenter());
		System.out.println("Center Radius: " + c.getRadius());
		System.out.println("The circle's area is " + c.getArea());
		System.out.println("\nAnother center coordinates: " + center.getCenter());
		System.out.println("Another Radius: " + center.getRadius());
		System.out.println("The another circle's area is " + center.getArea());
		
		
		if(center.equals(c) == true)
		{
		System.out.println("\nThe coordinates equal");
		}
		else
		{
		System.out.println("\nThe coordinates do not equal");
		}

		Scanner input = new Scanner(System.in);
		
		//Input coordinates and radius for c circle 
		System.out.print("\nEnter value for x coordinate: ");
		double x = input.nextDouble();
		c.setX(x);
		System.out.print("Enter value for y coordinate: ");
		double y = input.nextDouble();
		c.setY(y);
		System.out.print("Enter value for radius coordinate: ");
		double radius = input.nextDouble();
		c.setRadius(radius);

		//Input coordinates and radius for center circle
		System.out.print("Enter value for other x coordinate: ");
		double other_x = input.nextDouble();
		center.setX(other_x);
		System.out.print("Enter value for other y coordinate: ");
		double other_y = input.nextDouble();
		center.setY(other_y);
		System.out.print("Enter value for other radius: ");
		double other_radius = input.nextDouble();
		center.setRadius(other_radius);
		
		System.out.println("\n" + center.toString());
		
		center.doesOverlap(c);
		if(center.doesOverlap(c) == true)
		{
			System.out.println("\nCircle one and circle two overlap");
		}
		else
		{
			System.out.println("\nCircle one and circle two do not overlap");
		}

	}
}
//Testing...
//Center coordinates: (10.0, 20.0)
//Center Radius: 48.0
//The circle's area is 0.0
//
//Another center coordinates: (15.0, 30.0)
//Another Radius: 40.0
//The another circle's area is 0.0
//
//The coordinates equal
//
//Enter value for x coordinate: 4
//Enter value for y coordinate: 5
//Enter value for radius coordinate: 6
//Enter value for other x coordinate: 1
//Enter value for other y coordinate: 2
//Enter value for other radius: 3
//
//(Center coordinates: 1.0, 2.0), Radius: 3.0
//
//Circle one and circle two overlap
