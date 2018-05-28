import java.util.Scanner;

public class NumberGuesser
{
  public static void main(String args[])
  {
    //Main Methods
    do
    {
      playOneGame();
    }
    while(shouldPlayAgain());
  }
  
  //playOneGame(); method should have a return type of void
  //should implement a complete guessing game from 1 to 100.
    public static void playOneGame()
    {
      System.out.println("\nWelcome to the Number Guess Game. Think of a number between 1 and 100...\n");
      int low = 0;
      int high = 101;
      int guess;
      int usersResponseToGuess;
      
      //Invoke function getUserResponseToGuess(); and getMidPoint(); inside playOneGame();
      do
      {
        guess = getMidPoint(low, high);
        usersResponseToGuess = getUsersResponseToGuess(guess);
        //users guess is placed within method getUsersResponseToGuess()
        
        if(usersResponseToGuess == 'h')
        {
          low = guess;
        }
        else if(usersResponseToGuess == 'l')
        {
          high = guess;
        }
        else if(usersResponseToGuess == 'c')
        {
        }
      }
      while(usersResponseToGuess != 'c');
      //while user guess has not been guessed('c'= correct), continue to loop
    }
    
    //shouldPlayAgain method should have a boolean return type
    //prompt the user to determine if the user wants to play again
    //read in a character; return true if the character is 'y'
    //otherwise, return false
    public static boolean shouldPlayAgain()
    {
      System.out.print("Good Game! Enter yes or no to play again: ");
      Scanner keyboard = new Scanner(System.in);
      char playAgain = keyboard.next().charAt(0);
      
      if(playAgain == 'y')
      {
        return true;
      }
      else return false;
    }
    
    //getUsersResponseToGuess(); prompt the user: "is it <guess>? (h/l/c): "
    //user inputs value replacing the token <guess>
    //return char; char should be one of the three: 'h', 'l', or 'c'
    //Must have the following method title: public static char getUsersResponseToGuess(int guess){
    public static char getUsersResponseToGuess(int guess)
    {
      Scanner keyboard = new Scanner(System.in);
      char inputedValue; //user inputs whether guess is higher, lower or correct
      
      do
      {
        System.out.print("Is it " + guess + "? Enter 'h' for higher, 'l' for lower, or 'c' for correct: ");
        inputedValue = keyboard.next().charAt(0);
      }
      while(inputedValue != 'h' && inputedValue != 'l' && inputedValue != 'c');
      //ask for user input until inputed value equals higher, lower, or correct
      return inputedValue;
    }
    
    //getMidPoint(); function should except two integers; should return the mid point of the two integers
    //if two values in the middle of range, chose smaller of the two
    //Must have the following method title: public static int getMidPoint(int low, int high){
    public static int getMidPoint(int low, int high)
    {
      int mid;
      mid = (high + low)/2;
      return mid;
    }   
}
