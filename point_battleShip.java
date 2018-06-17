//Keeps track of the x & y coordinates
public class point_battleShip extends board_battleShip {
	
	int hits;
	
	point_battleShip(String[][]board, Object ship)
	{	
		ship_battleShip ship2 = new ship_battleShip(board,true,2);
		showBoard(board);
		ship_battleShip ship3 = new ship_battleShip(board,false,4);
		showBoard(board);
		int fire = 15;
		
		while(fire >= 0 && ship2.isHitAtPoint(board, fire) < 8)
		{
			fire--;
			ship2.isHitAtPoint(board, fire);
		}
		
		if(ship2.isHitAtPoint(board, fire) < 8)
		{
			System.out.println("There is no more fire to sink ships. You lost.");
		}
		else
		{
			if(fire < 1)
			{
				System.out.println("There is no more fire to sink ships. You lost.");
			}
			else
			{
				System.out.println("You have won the game Battle Ship!");
			}
		}
	}
}
