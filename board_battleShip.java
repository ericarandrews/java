//stores data of game
//include an array of ship objects
//include an arraylist of points that represent
	//the players guesses
//read in a coordinate from the player, say if it is a hit or a miss,
	//then display the board.
import java.util.*;
import java.util.Scanner;

public class board_battleShip{
	
	public static void main(String[]args)
	{
		String[][]board = new String[10][10];
		System.out.println("Welcome to Battleship.\n");
		createBoard(board);
		showBoard(board);
		ship_battleShip ship = new ship_battleShip(board,true,3);
		showBoard(board);
		point_battleShip x_y = new point_battleShip(board, ship);
	}

	public static final boolean COORDINATES = false;

	public static void createBoard(String[][]board)
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[0].length; column++)
			{
				board[row][column] = "~";	
			}
		}
	}

	public static void showBoard(String[][]board)
	{
		String[]yCoords = {"0","1","2","3","4","5","6","7","8","9"};
		String[]xCoords = {" 0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "," 9 "};
	
		for(int row = 0; row < board.length; row++)
		{	
			if(COORDINATES == true)
			{		
				System.out.print(yCoords[row]);
				
				for(int column = 0; column < board[0].length; column++)
				{
					System.out.print("  "+board[row][column]);
				}
				System.out.println("");
			}
			else
			{
				System.out.print(yCoords[row]);
				
				for(int column = 0; column < board[0].length; column++)
				{
					if(board[row][column].equals("o"))
					{	
						System.out.print(" "+" ~");		
					}
					else
					{
						System.out.print("  "+board[row][column]);
					}
					
				}
				System.out.println("");
			}	
		}
		System.out.print("  "+ xCoords[0]+""+ xCoords[1]+""+ xCoords[2]+""+ xCoords[3]);
		System.out.print(""+ xCoords[4]+""+ xCoords[5]+""+ xCoords[6]+""+ xCoords[7]);
		System.out.println(""+ xCoords[8]+""+ xCoords[9]+"\n\n");
	}
}
