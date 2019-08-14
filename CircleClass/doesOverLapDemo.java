//This program demonstrates the doesOverLap method
//Allocate and initialize at least three MyCircle objects. Two of them should overlap, and two should not.
//Display the areas of the three circles

public class doesOverLapDemo 
{	
	public static void main(String[]args)
	{
		//Create a Circle object
		MyCircle circle = new MyCircle();
		//Set x, y and radius
		circle.setX(5.0);
		circle.setY(6.0);
		circle.setRadius(20.0);
		circle.getArea();

		//Display x
		System.out.println("The circle's x is " + circle.getX());
		//Display y
		System.out.println("The circle's y is " + circle.getY());
		//Display radius
		System.out.println("The circle's radius is " + circle.getRadius());
		//Display area
		System.out.println("The circle's area is " + circle.getArea());
		
		
		//Create a Circle object
		MyCircle otherCircle = new MyCircle();
		//Set other_x, other_y and other_radius
		otherCircle.setX(3.0);
		otherCircle.setY(4.0);
		otherCircle.setRadius(15.0);
		otherCircle.getArea();

		//Display other_x
		System.out.println("\nThe circle's other_x is " + otherCircle.getX());
		//Display other_y
		System.out.println("The circle's other_y is " + otherCircle.getY());
		//Display other_radius
		System.out.println("The circle's other_radius is " + otherCircle.getRadius());
		//Display other_area
		System.out.println("The circle's other_area is " + otherCircle.getArea());
		
		
		//Create a Circle object
		MyCircle myOtherCircle = new MyCircle();
		//Set myOther_x, myOther_y and myOther_radius
		myOtherCircle.setX(8.0);
		myOtherCircle.setY(2.0);
		myOtherCircle.setRadius(10.0);
		myOtherCircle.getArea();

		//Display myOther_x
		System.out.println("\nThe circle's myOther_x is " + myOtherCircle.getX());
		//Display myOther_y
		System.out.println("The circle's myOther_y is " + myOtherCircle.getY());
		//Display myOther_radius
		System.out.println("The circle's myOther_radius is " + myOtherCircle.getRadius());
		//Display myOther_area
		System.out.println("The circle's myOther_area is " + myOtherCircle.getArea());
		
		
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


	

