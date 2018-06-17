
//CS111B
public abstract class abstractCell {
	
	private boolean isAlive;
	private int row;
	private int column;

	protected conwayWorld world;	
	
	public abstractCell(int r, int c, conwayWorld w) {
		row = r;
		column = c;
		world = w;
		isAlive = false;
	}
	
	public char displayCharacter() {
		return isAlive ? 'O' : '.';
	}
	
	public void setIsAlive(boolean value) {
		isAlive = value;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public abstract abstractCell cellForNextGeneration();
	public abstract boolean willBeAliveInNextGeneration();
}

