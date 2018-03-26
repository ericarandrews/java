import java.util.Scanner;
import java.util.Random;

public class BlackJack{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();
    
    char toPlay;
    int firstCard;
    int secondCard;//first set of cards
    
    int handTotal;
    int requestedCard;//hit me card
    int anotherCard;//user requests card; 'hit me'
    
    System.out.println("\nWelcome to the game of BlackJack.\n");
    System.out.print("Enter yes or no to play: ");
    toPlay = keyboard.next().charAt(0);
    
    while(toPlay == 'y'){
      firstCard = random.nextInt(10) + 1;
      secondCard = random.nextInt(10) + 1;
      System.out.println("\nFirst cards: " + firstCard + "," + secondCard);
      handTotal = firstCard + secondCard;
      System.out.println("Total: " + handTotal + "\n");
      System.out.print("Do you want another card? ");
      anotherCard = keyboard.next().charAt(0);
      
      if(anotherCard == 'n'){
        System.out.println("\nTotal: " + handTotal + ". Hand Rest.");
      }
      
      while(anotherCard == 'y'){
        requestedCard = random.nextInt(10) + 1;
        System.out.println("\nCard: " + requestedCard);
        handTotal = handTotal + requestedCard;
        System.out.println("Total: " + handTotal);
        
        if(handTotal == 21){
          System.out.println("\nTotal: " + handTotal + ". Winner!!!");
          break;
        }
        if(handTotal > 21){
          System.out.println("\nTotal: " + handTotal + ". Hand value is greater than 21.");
          System.out.println("Bust.");
          break;
        }
        
        System.out.print("Do you want another card? ");
        anotherCard = keyboard.next().charAt(0);
        
        if(anotherCard == 'n'){
          System.out.println("\nTotal: " + handTotal + ". Hand Rest.");
        }
      }
      System.out.print("Enter yes or no to play again: ");
      toPlay = keyboard.next().charAt(0);
    }
  }
}
