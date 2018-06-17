
//CS111B
public class neverAliveCell extends abstractCell {
	
	public neverAliveCell(int r, int c, conwayWorld w) {
		super(r, c, w);
	}
	
	public  abstractCell cellForNextGeneration() {
		return this;
	}
	
	public boolean willBeAliveInNextGeneration() {
		return false;
	}

	public char displayCharacter() {
		return 'X';
	}
	
	public boolean getIsAlive() {
		return false;
	}
}
