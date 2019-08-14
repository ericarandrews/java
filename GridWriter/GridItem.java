	
public interface GridItem {
		
	public int getX();
	public void setX(int value);
	public int getY();
	public void setY(int value);
	public abstract double getArea();
	public abstract boolean containsPoint(int xValue, int yValue);
	
}
