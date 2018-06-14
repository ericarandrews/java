public class AddingExceptions_MyCircle_GridWriter implements GridItem 
{
	private int radius;
	
	protected int x;
	protected int y;
	
	public AddingExceptions_MyCircle_GridWriter(int xValue, int yValue, int r) {
		x = xValue;
		y = yValue;
		radius = r;
	}
	
	@Override
	public int getX() {return x;}
	
	@Override
	public void setX(int value) {x = value;}
	
	@Override
	public int getY() {return y;}
	
	@Override
	public void setY(int value) {y = value;}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public boolean containsPoint(int xValue, int yValue) {
		double dx = x - xValue;
		double dy = y - yValue;
		double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		return distance <= radius;
	}
}
