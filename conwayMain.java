import java.util.*;

public class conwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		conwayWorld world = new conwayWorld();

		// Add some live conway cells, in a horizontal line		
		 for (int i = 0; i < 8; i++) 
		 {
		 	conwayCell c = new conwayCell(5, 5 + i, world);	
		 	c.setIsAlive(true);
		 	world.replaceCell(c);
		 }
		 
		 //Add some live blinker cells, in a vertical line to a horizontal line
		 for (int i = 0; i < 3; i++) 
		 {
		 	blinkerCell b = new blinkerCell(i, 1, world);
		 	b.setIsAlive(true);
		 	world.replaceCell(b);
		 }
		
		// Add an always-alive cells
		abstractCell a = new alwaysAliveCell(12, 12, world);
		world.replaceCell(a);
			
		// Add an always-alive cells
		abstractCell n = new neverAliveCell(17, 17, world);
		world.replaceCell(n);
			
		// Go!	
		do {
			world.display();
			//
			world.advanceToNextGeneration();
			
			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}
}
