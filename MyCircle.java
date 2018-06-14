public class MyCircle 
{	
	private double x;
	private double y;
	private double radius;
	private double area;

	final double PI = 3.14159;
	
	//The setX method stores a value in the x field
	//@param value The value to store in x
	public void setX(double value)
	{
		x = value;
	}
	
	//The setY method stores a value in the y field
	//@param value The value to store in y
	public void setY(double value)
	{
		y = value;
	}

	//The setRadius method stores a value in the radius
	//@param value The value to store in radius
	public void setRadius(double value)
	{
		radius = value;
	}

	//The getX method returns a Circle object's x.
	//@return The value in the x field
	public double getX()
	{
		return x;
	}

	//The getY method returns a Circle object's y.
	//@return The value in the y field
	public double getY()
	{
		return y;
	}

	//The getRadius method returns a Circle object's radius
	//@return The product of radius
	public double getRadius()
	{
		return radius;
	}

	//The getArea method returns a Circle object's area
	//@return The product of area
	public double getArea()
	{
		return area = PI * radius * radius;
	}
	
	//This method should accept a MyCircle as an argument, 
	//and return true if this circle overlaps the circle that the method was invoked on.  
	//Note: two circles overlap if the sum of their radius' is greater than the distance between their centers.
	public boolean doesOverlap(MyCircle otherCircle)
	{
		double other_x = 0;
		double other_y = 0;
		double other_radius = 0;
		
		double distance = Math.sqrt(Math.pow((x - other_x), 2) + Math.pow((y - other_y), 2));
		//double boundary_distances = distance - (radius + other_radius);
		
		if(distance < (radius + other_radius))
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	
}
