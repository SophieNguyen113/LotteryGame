import java.util.Scanner;
import java.util.Arrays;
/**
  * Programming Project 
  * This program completes a lottery game program. 
  * Developed a Java program to let user pick 5 valid numbers and check if the user is the Grand Prize Winner.
  * Utilized scanner class, constants, variables, printf, if/else statements, Boolean statements, while loops, 
      for loops, methods (parameters and return values), and arrays in Java programming language to build the project.
  * Succeed in checking the result with 100% accuracy in under 1 second.
  * @author Sophie Nguyen
  * @version March 2022
  */

public class LotteryGame
{   
   static final int NUM_DIGITS = 5;
   
   /**
     * Outputs the welcome message for the user.
     * No @param 
     * No @return 
     */
   public static void greetUser()
   {
      System.out.println("       Welcome to the Lottery Game");
      System.out.println("You will pick 5 numbers (0 - 9) and we will");
      System.out.println("see if you are the Grand Prize Winner!");
      System.out.println("");
   }
   
   /**
     * Randomly gets lottery numbers.
     * No @param 
     * @return an array of lottery numbers that are randomly chose
     */
   public static int[] getLotteryNumbers()
   {
      Scanner in = new Scanner(System.in);
      int[] lotNumbers = new int[NUM_DIGITS];
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         lotNumbers[i] = (int) (Math.random() * 9) + 0;
      }
      Arrays.sort(lotNumbers);
      
      System.out.print("Lottery Numbers: ");
      for (int element : lotNumbers)
      {
         System.out.print(element + " ");
      }
      System.out.println("");
      
      return lotNumbers;
   }
   
   /**
     * Lets user pick lottery numbers.
     * No @param 
     * @return an array of lottery numbers that user picks
     */
   public static int[] getUserPicks()
   {
      Scanner in = new Scanner(System.in);
      int[] pickedNumbers = new int[NUM_DIGITS];
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         System.out.printf("Enter pick %d (0 - 9): ", i + 1);
         int input = in.nextInt();
          
        /**
          * Validates that the input is between 0 and 9.
          * If it is not, output an "ERROR" message and prompt the user to enter again.
          */
         boolean valid = true;     
         while(valid)
         {
            if (input >= 0 && input <= 9)
            {
               pickedNumbers[i] = input;    
               valid = false;     
            }
            else
            {
               System.out.print("ERROR. Please enter a number (0 - 9): ");
               input = in.nextInt();
            }   
         }
      }
      System.out.println("");
      Arrays.sort(pickedNumbers);
      
      return pickedNumbers;
   }
   
   /**
     * Finds matches between the random lottery numbers and lottery numbers that user picks.
     * @param arrayRandom and arrayUserPicks
     * @return the number of matches
     */
   public static int findMatches(int[] arrayRandom, int[] arrayUserPicks)
   {
      int matches = 0;
      for (int i = 0; i < NUM_DIGITS; i++)
      {
         if (arrayRandom[i] == arrayUserPicks[i])
         {
            matches++;
         }
      }
      
      return matches;
   }
   
   public static void main(String[] args)
   {
      greetUser();
      
      int[] pickedNumbers = getUserPicks();

      int[] lotNumbers = getLotteryNumbers();
      
      int matches = findMatches(lotNumbers, pickedNumbers);
      System.out.println("Number of matching digits: " + matches); 
      
      if (matches == NUM_DIGITS) // tests if the number of matches is 5.
      {
         System.out.println("GRAND PRIZE WINNER!"); 
      }
      else
      {
         System.out.println("Sorry, you didn't win."); 
      }
    }
}