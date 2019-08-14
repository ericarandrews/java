public class PointTest {
	
	public static void main(String[]args)
	{
		Point p = new Point(10,25);
			
		System.out.println(p.toString());
		
		p.setX(5);
		p.setY(10);
		
		System.out.println("Point p has been relocated to the following coordinates: ");
		System.out.println(p.toString());
		
	}

}
