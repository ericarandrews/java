//This program demonstrates the Circle class
import java.util.Scanner;

public class MyCircleTester 
{	
	public static void main(String[]args)
	{
		//Input circle classes
		MyCircle circle = new MyCircle();
		MyCircle otherCircle = new MyCircle();
		MyCircle myOtherCircle = new MyCircle();
		
		//User inputs values for circle classes
		Scanner input = new Scanner(System.in);
		
		//Input coordinates and radius for circle 
		System.out.print("Enter value for x coordinate: ");
		double x = input.nextDouble();
		circle.setX(x);
		System.out.print("Enter value for y coordinate: ");
		double y = input.nextDouble();
		circle.setY(y);
		System.out.print("Enter value for radius coordinate: ");
		double radius = input.nextDouble();
		circle.setRadius(radius);

		//Input coordinates and radius for other circle
		System.out.print("\nEnter value for other x coordinate: ");
		double other_x = input.nextDouble();
		otherCircle.setX(other_x);
		System.out.print("Enter value for other y coordinate: ");
		double other_y = input.nextDouble();
		otherCircle.setY(other_y);
		System.out.print("Enter value for other radius: ");
		double other_radius = input.nextDouble();
		otherCircle.setRadius(other_radius);

		//Input coordinates and radius for my other circle
		System.out.print("\nEnter value for my other x coordinate: ");
		double myOther_x = input.nextDouble();
		myOtherCircle.setX(myOther_x);
		System.out.print("Enter value for my other y coordinate: ");
		double myOther_y = input.nextDouble();
		myOtherCircle.setY(myOther_y);
		System.out.print("Enter value for my other radius: ");
		double myOther_radius = input.nextDouble();
		myOtherCircle.setRadius(myOther_radius);
		
		//Display areas
		System.out.println("\nThe first circle's area is " + circle.getArea());
		System.out.println("The second circle's area is " + otherCircle.getArea());
		System.out.println("The third circle's area is " + myOtherCircle.getArea()); 				
		
		
		circle.doesOverlap(circle);
		if(circle.doesOverlap(circle) == true)
		{
			System.out.println("\nCircle one and circle two overlap");
		}
		else
		{
			System.out.println("\nCircle one and circle two do not overlap");
		}
		
		otherCircle.doesOverlap(otherCircle);
		if(otherCircle.doesOverlap(otherCircle) == true)
		{
			System.out.println("Circle two and circle three overlap");
		}
		else 
		{
			System.out.println("Circle two and circle three do not overlap");
		}
		
		myOtherCircle.doesOverlap(myOtherCircle);
		if(myOtherCircle.doesOverlap(myOtherCircle) == true)
		{
			System.out.println("Circle three and circle one do not overlap");
		}
		else
		{
			System.out.println("Circle three and circle one do not overlap");
		}	
	}	
}
//Enter value for x coordinate: 6
//Enter value for y coordinate: 5
//Enter value for radius coordinate: 2
//
//Enter value for other x coordinate: 3
//Enter value for other y coordinate: 2
//Enter value for other radius: 7
//
//Enter value for my other x coordinate: 8
//Enter value for my other y coordinate: 9
//Enter value for my other radius: 4
//
//The first circle's area is 12.56636
//The second circle's area is 153.93791
//The third circle's area is 50.26544
//
//Circle one and circle two do not overlap
//Circle two and circle three overlap
//Circle three and circle one do not overlap


