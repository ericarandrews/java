
public class blinkerCell extends abstractCell {

	public blinkerCell(int r, int c, conwayWorld w) {
		super(r, c, w);
	}	

	public boolean willBeAliveInNextGeneration() {
		int nc = neighborCount();
		
		if (getIsAlive()) {
			return nc == 2 || nc == 3;
		} else {
			return nc == 3;
		}
	}
	
	public abstractCell cellForNextGeneration() {
		blinkerCell next = new blinkerCell(getRow(), getColumn(), world);
		
		next.setIsAlive(willBeAliveInNextGeneration());
		
		return next;
	}
	
	public int neighborCount() {
		int count = 0;
		
		int row = getRow();
		int column = getColumn();
		
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
					count++;
				}
			}
		}
		
		return count;
	}
}
