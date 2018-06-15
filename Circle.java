
public class Circle 
{
	private Point center;
	private double radius;
	
	public Circle()
	{
		center = new Point(0,0);
		radius = 1;
	}
	public Circle(double xValue, double yValue, double r)
	{
		this.center = new Point(xValue, yValue);
		this.radius = r;	
	}
	public Circle(Point o, double r)
	{
		center = new Point(o);
		radius = r;
	} 
	public Circle(Circle c)
	{	
		this(c.getCenter(), c.getRadius());
	}

	
	public void setCenter(Point p)
	{
		center = new Point(p);
	}
	public void setX(double value)
	{
		center.setX(value);
	}
	public void setY(double value)
	{
		center.setY(value);
	}
	public void setRadius(double value)
	{
		radius = value;
	}


	public Point getCenter()
	{
		return new Point(center);
	}
	public double getX()
	{
		return center.getX();
	}
	public double getY()
	{
		return center.getY();
	}
	public double getRadius()
	{
		return radius;
	}
	public double getArea()
	{
		return 0;
	}


	public String toString()
	{
		return "(Center coordinates: " + center.getX() + ", " + center.getY() + "), Radius: " + radius;
	}
	
	public boolean equals(Circle c)
	{	
		
		if(this.center.equals(c.center) && (this.radius - c.radius < 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean doesOverlap(Circle c)
	{	

		double distance = Math.sqrt(Math.pow((this.center.getX() - c.center.getX()), 2) + Math.pow((this.center.getY() - c.center.getY()), 2));
		//double boundary_distances = distance - (radius + other_radius);
		
		if(distance <= (c.radius + this.radius))
		{
		return true;
		}
		else
		{
		return false;
		}
	
	 }
}

