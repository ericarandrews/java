import java.util.Scanner;

//Stores the data of each ship (5 of these)
//include two Arraylists of points: 
	//one to store the points that the ship covers
	//one to store the points that have been "hit" by the player
public class ship_battleShip extends board_battleShip{
	
	protected int xPoint;
	protected int yPoint;
	protected int xPoint1;
	protected int yPoint1;
	protected int xPoint2;
	protected int yPoint2;
	protected int hits;

//this constructor accepts the origin or the ship (its lowest, or leftmost point),
//its length, and its orientation(vertical, or horizontal).
	ship_battleShip(String[][]board, boolean isVertical, int length)
	{		
		Scanner input = new Scanner(System.in);
		
		if(isVertical == false)
		{	
			System.out.print("Enter x coordinate for horizontal ship: ");
			xPoint1 = input.nextInt();
			System.out.print("Enter y coordinate for horizontal ship: ");
			yPoint1 = input.nextInt();
			
			if(length > 4)
			{
				System.out.println("Ship length must be 4 or less");
			}
			
			if(length == 4)
			{
				if(xPoint1 <= 6)
				{
					for(int i = 0; i < length; i++)
					{
						board[yPoint1][xPoint1 + i] = "o";
					}
				}
				if(xPoint1 > 6)
				{
					System.out.println("For this ship, the x coordinate can be no greater than 6");
				}
			}
		
			if(length == 3)
			{
				if(xPoint1 <= 7)
				{
					for(int z = 0; z < length; z++)
					{
						board[yPoint1][xPoint1 + z] = "o";
					}
				}
				if(xPoint1 > 7)
				{
					System.out.println("For this ship, the x coordinate can be no greater than 7");
				}
			}
				
			if(length == 2)
			{
				if(xPoint1 <= 8)
				{
					for(int a = 0; a < length; a++)
					{
						board[yPoint1][xPoint1 + a] = "o";
					}
				}
				if(xPoint1 > 8)
				{
					System.out.println("For this ship, the x coordinate can be no greater than 8");
				}
			}
			if(length < 2)
			{
				System.out.println("Ship length must be 2 or greater");
			}
		}
		if(isVertical == true)
		{

			System.out.print("Enter x coordinate for vertical ship: ");
			xPoint2 = input.nextInt();
			System.out.print("Enter y coordinate for vertical ship: ");
			yPoint2 = input.nextInt();
			
			if(length > 4)
			{
				System.out.println("Ship length must be 4 or less");
			}
			if(length == 4)
			{
				if(yPoint2 <= 6)
				{
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
				}
				if(yPoint2 > 6)
				{
					System.out.println("For this ship, the y coordinate can be no greater than 6");
				}
			}
			if(length == 3)
			{
				if(yPoint2 <= 7)
				{
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
				}
				if(yPoint2 > 7)
				{
					System.out.println("For this ship, the y coordinate can be no greater than 7");
				}
			}
			if(length == 2)
			{
				if(yPoint2 <= 8)
				{
					board[yPoint2][xPoint2] = "o";
					yPoint2 = yPoint2 + 1;
					board[yPoint2][xPoint2] = "o";
				}
				if(yPoint2 > 8)
				{
					System.out.println("For this ship, the y coordinate can be no greater than 8");
				}
			}
			if(length < 2)
			{
				System.out.println("Ship length must be 2 or greater");
			}		
		 }
	   }

	//this is a verb in the game. When the user enters a coordinate, this method can be 
		//called on each ship. If the ship contains the point, it should remember that 
		//it has been hit at that point. 
	//Note: it could do this with a second PointCollection, or some other data strategy.
	void shotFiredAtPoint(String[][]board)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter row to fire at point: ");
		yPoint = input.nextInt();
		while(yPoint > 9 || yPoint < 0)
		{
			System.out.println("Enter row range between 0 to 9:");
			yPoint = input.nextInt();
		}
		
		System.out.print("Enter column to fire at point: ");
		xPoint = input.nextInt();
		while(xPoint > 9 || xPoint < 0)
		{
			System.out.println("Enter column range between 0 to 9:");
			xPoint = input.nextInt();
		}	
	}

	//returns true if shotFiredAtPoint has been called for this point in the ship.
	//False if it has not, or if the point is not in the ship.
	int isHitAtPoint(String[][]board, int fire)
	{
		shotFiredAtPoint(board);
		if(board[yPoint][xPoint].equals("o"))
		{
			System.out.println("--------------Hit!--------------\n");
			board[yPoint][xPoint] = "X";
			hits++;
			hitCount(hits);
		}
		else
		{
			System.out.println("--------------Miss!--------------\n");
			board[yPoint][xPoint] = ".";
		}
		System.out.println("There is only "+fire +" left to fire at point...");		
		showBoard(board);
		return hits;
	}

	//returns the number of points in the ship that have been hit. When the hitCount is 
		//equal to the length of the ship the ship is considered to be sunk.
	public static void hitCount(int hits)
	{	
		System.out.println("Hits: " +hits);
	}	
	
}
