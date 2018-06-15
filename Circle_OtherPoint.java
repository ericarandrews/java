
public class Circle_OtherPoint 
{
	private Point center;
	private double radius;

	private double x;
	private double y;
	private double area;
	final double PI = 3.14159;

	
	public Circle_OtherPoint()
	{
		center = new Point(0,0);
		radius = 1;
	}
	public Circle_OtherPoint(double xValue, double yValue, double r)
	{
		center = new Point(xValue, yValue);
		radius = r;	
	}
	public Circle_OtherPoint(Point o, double r)
	{
		center = new Point(o);
		radius = r;
	} 
	public Circle_OtherPoint(Circle_OtherPoint c)
	{	
		center = c.center;
		radius = c.radius;
	}

	
	public void setCenter(Point p)
	{
		this.center = p;
	}
	public void setX(double value)
	{
		this.x = value;
	}
	public void setY(double value)
	{
		this.y = value;
	}
	public void setRadius(double value)
	{
		this.radius = value;
	}


	public Point getCenter()
	{
		return center;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getRadius()
	{
		return radius;
	}
	public double getArea()
	{
		return area = PI * radius * radius;
	}


	public String toString()
	{
		return "(" + this.x + ", " + this.y + ") radius: " + radius;
	}
	
	public boolean equals(Circle_OtherPoint c)
	{	
		if(c == null)
		{
			return false;
		}
		if(c.getCenter() != this.getCenter())
		{
			return false;
		}
		if(c == this) 
		{
			return true;
		}
		return false;
	}
	
	public boolean doesOverlap(Circle_OtherPoint c)
	{	
		double distance = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
		//double boundary_distances = distance - (radius + other_radius);
		
		if(distance < (radius + this.radius))
		{
		return true;
		}
		else
		{
		return false;
		}
	
	 }
}

