
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PokerHand{
	public static void main(String args[]){
		int cards = 5;
		int [] hand = new int [cards];
		char playAgain = 0;
		
		while(playAgain != 'n'){
			System.out.println("\nWelcome to the Poker Hand game.");
			System.out.println("Enter five numeric cards, no face cards. Use 2- 9.");
			Scanner keyboard = new Scanner(System.in);
			
			System.out.print("\nCard 1: ");
			hand[0] = keyboard.nextInt();
			System.out.print("Card 2: ");
			hand[1] = keyboard.nextInt();
			System.out.print("Card 3: ");
			hand[2] = keyboard.nextInt();
			System.out.print("Card 4: ");
			hand[3] = keyboard.nextInt();
			System.out.print("Card 5: ");
			hand[4] = keyboard.nextInt();
			
			containsFourOfAKind(hand);
			containsFullHouse(hand);
			containsStraight(hand);
			containsThreeOfAKind(hand);
			containsTwoPair(hand);
			containsPair(hand);
			
			if(containsFourOfAKind(hand) == true){
				System.out.println("Four of a Kind!");
			}
			else if(containsFullHouse(hand) == true){
				System.out.println("Full House!");
			}
			else if(containsStraight(hand) == true){
				System.out.println("Straight!");
			}
			else if(containsThreeOfAKind(hand) == true){
				System.out.println("Three of a Kind!");
			}
			else if(containsTwoPair(hand) == true){
				System.out.println("Two Pair!");
			}
			else if(containsPair(hand) == true){
				System.out.println("Pair!");
			}
			else{
				System.out.println("High Card!");
			}
			
			System.out.print("\nWould you like to play again? ");
			playAgain = keyboard.next().charAt(0);
		}
	}
	//Two of the cards are identical
	public static boolean containsPair(int hand []){
		if((hand[0] == hand[1]) || (hand[0] == hand[2]) || (hand[0] == hand[3]) || (hand[0] == hand[4]) ||
				(hand[1] == hand[2]) || (hand[1] == hand[3]) || (hand[1] == hand[4]) || (hand[1] == hand[0]) || 
				(hand[2] == hand[3]) || (hand[2] == hand[4]) || (hand[2] == hand[0]) || (hand[2] == hand[1]) ||
				(hand[3] == hand[4]) || (hand[3] == hand[0]) || (hand[3] == hand[1]) || (hand[3] == hand[2]) || 
				(hand[4] == hand[0]) || (hand[4] == hand[1]) || (hand[4] == hand[2]) || (hand[4] == hand[3]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Two different pairs
	public static boolean containsTwoPair(int hand[]){
		if(((hand[0] == hand[1]) && (hand[2] == hand[3])) || 
			((hand[0] == hand[2]) && (hand[3] == hand[4])) ||
			((hand[0] == hand[3]) && (hand[4] == hand[1])) ||
			((hand[0] == hand[4]) && (hand[1] == hand[2])) ||
			
			((hand[1] == hand[2]) && (hand[3] == hand[4])) ||
			((hand[1] == hand[3]) && (hand[4] == hand[0])) ||
			((hand[1] == hand[4]) && (hand[0] == hand[2])) ||
			((hand[1] == hand[0]) && (hand[2] == hand[3])) ||
			
			((hand[2] == hand[3]) && (hand[4] == hand[0])) || 
			((hand[2] == hand[4]) && (hand[0] == hand[1])) ||
			((hand[2] == hand[0]) && (hand[1] == hand[3])) ||
			((hand[2] == hand[1]) && (hand[3] == hand[4])) ||
			
			((hand[3] == hand[4]) && (hand[0] == hand[1])) ||
			((hand[3] == hand[0]) && (hand[1] == hand[2])) ||
			((hand[3] == hand[1]) && (hand[2] == hand[4])) ||
			((hand[3] == hand[2]) && (hand[4] == hand[0])) ||
			
			((hand[4] == hand[0]) && (hand[1] == hand[2])) ||
			((hand[4] == hand[1]) && (hand[2] == hand[3])) ||
			((hand[4] == hand[2]) && (hand[3] == hand[0])) ||
			((hand[4] == hand[3]) && (hand[0] == hand[1])))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	//Three matching cards
	public static boolean containsThreeOfAKind(int hand[]){
		if(((hand[0] == hand[1]) && (hand[0] == hand[2])) ||
			((hand[0] == hand[2]) && (hand[0] == hand[3])) ||
			((hand[0] == hand[3]) && (hand[0] == hand[4])) ||
			((hand[0] == hand[4]) && (hand[0] == hand[1])) ||
			
			((hand[1] == hand[2]) && (hand[1] == hand[3])) ||
			((hand[1] == hand[3]) && (hand[1] == hand[4])) ||
			((hand[1] == hand[4]) && (hand[1] == hand[0])) ||
			((hand[1] == hand[0]) && (hand[1] == hand[2])) ||
			
			((hand[2] == hand[3]) && (hand[2] == hand[4])) ||
			((hand[2] == hand[4]) && (hand[2] == hand[0])) ||
			((hand[2] == hand[0]) && (hand[2] == hand[1])) ||
			((hand[2] == hand[1]) && (hand[2] == hand[3])) ||
			
			((hand[3] == hand[4]) && (hand[3] == hand[0])) ||
			((hand[3] == hand[0]) && (hand[3] == hand[1])) ||
			((hand[3] == hand[1]) && (hand[3] == hand[2])) ||
			((hand[3] == hand[2]) && (hand[3] == hand[4])) ||
			
			((hand[4] == hand[0]) && (hand[4] == hand[1])) ||
			((hand[4] == hand[1]) && (hand[4] == hand[2])) ||
			((hand[4] == hand[2]) && (hand[4] == hand[3])) ||
			((hand[4] == hand[3]) && (hand[4] == hand[0])))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
		//Card values can be arranged in order
		public static boolean containsStraight(int hand[]){
			Arrays.sort(hand);
			if(((hand[0] == 2) && (hand[1] == 3) && (hand[2] == 4) && (hand[3] == 5) && (hand[4] == 6)) ||
				((hand[0] == 3) && (hand[1] == 4) && (hand[2] == 5) && (hand[3] == 6) && (hand[4] == 7)) ||
				((hand[0] == 4) && (hand[1] == 5) && (hand[2] == 6) && (hand[3] == 7) && (hand[4] == 8)) ||
				((hand[0] == 5) && (hand[1] == 6) && (hand[2] == 7) && (hand[3] == 8) && (hand[4] == 9)))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//A pair, and a three of a kind
	    public static boolean containsFullHouse(int hand[]){
	        if((((hand[0] == hand[1]) && (hand[0] == hand[2])) && (hand[3] == hand[4])) ||
	                (((hand[0] == hand[2]) && (hand[0] == hand[3])) && (hand[4] == hand[1])) ||
	                (((hand[0] == hand[3]) && (hand[0] == hand[4])) && (hand[1] == hand[2])) ||
	                (((hand[0] == hand[4]) && (hand[0] == hand[1])) && (hand[2] == hand[3])) ||

	                (((hand[1] == hand[2]) && (hand[1] == hand[3])) && (hand[4] == hand[0])) ||
	                (((hand[1] == hand[3]) && (hand[1] == hand[4])) && (hand[0] == hand[2])) ||
	                (((hand[1] == hand[4]) && (hand[1] == hand[0])) && (hand[2] == hand[3])) ||
	                (((hand[1] == hand[0]) && (hand[1] == hand[2])) && (hand[3] == hand[4])) ||

	                (((hand[2] == hand[3]) && (hand[2] == hand[4])) && (hand[0] == hand[1])) ||
	                (((hand[2] == hand[4]) && (hand[2] == hand[0])) && (hand[1] == hand[3])) ||
	                (((hand[2] == hand[0]) && (hand[2] == hand[1])) && (hand[3] == hand[4])) ||
	                (((hand[2] == hand[1]) && (hand[2] == hand[3])) && (hand[4] == hand[0])) ||

	                (((hand[3] == hand[4]) && (hand[3] == hand[0])) && (hand[1] == hand[2])) ||
	                (((hand[3] == hand[0]) && (hand[3] == hand[1])) && (hand[2] == hand[4])) ||
	                (((hand[3] == hand[1]) && (hand[3] == hand[2])) && (hand[4] == hand[0])) ||
	                (((hand[3] == hand[2]) && (hand[3] == hand[4])) && (hand[0] == hand[1])) ||

	                (((hand[4] == hand[0]) && (hand[4] == hand[1])) && (hand[2] == hand[3])) ||
	                (((hand[4] == hand[1]) && (hand[4] == hand[2])) && (hand[3] == hand[0])) ||
	                (((hand[4] == hand[2]) && (hand[4] == hand[3])) && (hand[0] == hand[1])) ||
	                (((hand[4] == hand[3]) && (hand[4] == hand[0])) && (hand[1] == hand[2])))
	        {
	            return true;
	        }
	        else
	        {
	            return false;

	        }
	    }
	    
	  //Four matching cards
	    public static boolean containsFourOfAKind(int hand[]){
	        if(((hand[0] == hand[1]) && (hand[0] == hand[2]) && (hand[0] == hand[3]) && (hand[0] != hand[4])) ||
	                ((hand[1] == hand[2]) && (hand[1] == hand[3]) && (hand[1] == hand[4]) && (hand[1] != hand[0])) ||
	                ((hand[2] == hand[3]) && (hand[2] == hand[4]) && (hand[2] == hand[0]) && (hand[2] != hand[1])) ||
	                ((hand[3] == hand[4]) && (hand[3] == hand[0]) && (hand[3] == hand[1]) && (hand[3] != hand[2])) ||
	                ((hand[4] == hand[0]) && (hand[4] == hand[1]) && (hand[4] == hand[2]) && (hand[4] != hand[3])))
	        {
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }
	}

