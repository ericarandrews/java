
public class OtherPoint {

	private Point center;
	private double radius;

	private double other_x;
	private double other_y;
	private double other_area;
	final double PI = 3.14159;

	
	public OtherPoint(Point o, double r)
	{
		this.center = new Point(o);
		this.radius = r;
	} 
	public OtherPoint(double xValue, double yValue, double r)
	{
		this.center = new Point(xValue, yValue);
		this.radius = r;	
	}
	public OtherPoint()
	{
		this.center = new Point(0,0);
		this.radius = 1;
	}
	public OtherPoint(OtherPoint c)
	{
		center = c.center;
		this.radius = radius;
	}

	
	public void setCenter(Point p)
	{
		this.center = p;
	}
	public void setX(double value)
	{
		this.other_x = value;
		
	}
	public void setY(double value)
	{
		this.other_y = value;
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
		return other_x;
	}
	public double getY()
	{
		return other_y;
	}
	public double getRadius()
	{
		return radius;
	}
	public double getArea()
	{
		return other_area = PI * radius * radius;
	}


	public String toString()
	{
		return "(" + this.other_x + ", " + this.other_y + ") radius: " + radius;
	}
	public boolean equals(Circle c)
	{
		if(c == null)
		{
		return false;
		}
		if(getCenter() != c.getCenter())
		{
			return false;
		}
		return false;
	}
		
	public boolean doesOverlap(Circle c)
	{		
		double x = 0;
		double y = 0;
		double radius = 0;
		
		double distance = Math.sqrt(Math.pow((x - this.other_x), 2) + Math.pow((y - this.other_y), 2));
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


