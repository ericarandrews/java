import java.util.Scanner;

public class PointEqualsMethodDemo {

	public static void main(String[]args)
	{
		
		Point center = new Point();
		Point otherPoint = new Point();
		
		Scanner input = new Scanner(System.in);
				
		System.out.print("Enter x coordinate for center point: ");
		double x = input.nextDouble();
		otherPoint.setX(x);
		System.out.print("Enter y coordinate for center point: ");
		double y = input.nextDouble();
		otherPoint.setY(y);
		
		System.out.print("Enter x coordinate for other center point: ");
		double xValue = input.nextDouble();
		System.out.print("Enter y coordinate for other center point: ");
		double yValue = input.nextDouble();
		center = new Point(xValue, yValue);
		
		if((center.equals(otherPoint)) == true)
		{
			System.out.println("\nThe center points equal the other center points");
		}
		else
		{
			System.out.println("\nThe center points DO NOT equal the other center points");
		}
		
		System.out.print("(x, y) : "+ center.toString());

	}
}
