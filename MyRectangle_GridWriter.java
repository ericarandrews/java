public class MyRectangle_GridWriter implements GridItem 
{
	private int height;
	private int width;
	
	protected int x;
	protected int y;
	
	public MyRectangle_GridWriter(int xValue, int yValue, int w, int h) {
		x = xValue;
		y = yValue;
		width = w;
		height = h;
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int value) {
		x = value;
	}
	
	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setY(int value) {
		y = value;
	}

	@Override
	public double getArea() {
		return height * width;
	}
	
	@Override
	public boolean containsPoint(int xValue, int yValue) {
		return	xValue >= x &&
		xValue <= x + width &&
		yValue >= y &&
		yValue <= y + height;
	}
}
