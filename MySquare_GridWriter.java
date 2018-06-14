
public class MySquare_GridWriter implements GridItem {

	private int side;
	
	protected int x;
	protected int y;
	
	public MySquare_GridWriter(int xValue, int yValue, int s){
		x = xValue;
		y = yValue;
		side = s;
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
		return side * side;
	}

	@Override
	public boolean containsPoint(int xValue, int yValue) {
		return	xValue <= x + side && xValue >= x &&
				yValue <= y + side && yValue >= y;	
	}

}
