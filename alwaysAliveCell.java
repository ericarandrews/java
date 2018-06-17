
//CS111B
public class alwaysAliveCell extends abstractCell {
	
	public alwaysAliveCell(int r, int c, conwayWorld w) {
		super(r, c, w);
	}
	
	public  abstractCell cellForNextGeneration() {
		return this;
	}
	
	public boolean willBeAliveInNextGeneration() {
		return true;
	}
	
	public boolean getIsAlive() {
		return true;
	}
	
	public char displayCharacter() {
		return '+';
	}
}
