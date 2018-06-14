
public class GridWriterProgram {
	
	public static void main(String[] args){
		
		GridWriter gw = new GridWriter(40, 50);
			
		gw.add(new MyCircle_GridWriter(10, 10, 9));
		gw.add(new MyCircle_GridWriter(25, 20, 12));
		gw.add(new MyCircle_GridWriter(25, 20, 5));
		
		gw.add(new MyRectangle_GridWriter(25, 25, 20, 15));
		gw.add(new MyRectangle_GridWriter(5, 5, 3, 4));
		gw.add(new MyRectangle_GridWriter(40, 0, 10, 10));
		
		gw.add(new MySquare_GridWriter(1, 35, 5));
		gw.add(new MySquare_GridWriter(6, 30, 6));
		gw.add(new MySquare_GridWriter(12, 35, 5));
		gw.add(new MySquare_GridWriter(27, 0, 4));
			
		gw.display();
		
		//Returns the number of GridItems stored in the GridWriter
		System.out.println("\nNumber of items stored in the GridWriter: " +  gw.size() + "\n");
		
		//Returns the stored GridItems by index
		for(int i = 0; i < gw.size(); i++)
		{
			System.out.println("GridItem containing point: (" +  gw.get(i).getX() + ", " + gw.get(i).getY() + ")");
		}
		
		//Code to cause your GridWriter to throw an IndexOutOfBoundsException due to invalid index
//		GridItem i = gw.get(gw.size() + 1);
		
	}
}
