import java.util.InputMismatchException;
import java.util.Scanner;

/**
 The TowersGame class creates a Towers of Hanoi game. Directions: There are 3
 Pegs or Towers to stack rings on. At the start of the game, all the rings are
 on the first peg. They are stacked in order of the largest diameter on the
 bottom to the smallest diameter on the top. The object of the game is to get
 all rings on to Peg/Tower number 2 in order from the smallest on top to the
 largest at the bottom. Rules: 1. Only one ring may be moved at a time. 2. A
 larger ring may never be stacked on top of a smaller ring at any time. 3. Only
 the top ring on a stack may be moved. 4. A ring can be moved to any peg, so
 long as rule number 2 is not violated. 5. A ring must be moved to a different
 peg than the one it is currently on.

 @author Peer Halvorsen
 */
public class TowersGame
{

    public static void main(String[] args)
    {
        boolean quit = false; //allows for quit condition

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Towers of Hanoi");
        int answer = 0;
        int startPeg = 0;
        int endPeg = 0;
        
        //get user input
        System.out.print("How many rings would you like to play with (1-64)?");
        try
        {
            answer = keyboard.nextInt();

            //validate that number of rings is between 1 and 64
            while ((answer < 1 || answer > 64))
            {
                System.out.print("Invalid number of rings. Please enter a number"
                        + " between 1 and 64:");
                answer = keyboard.nextInt();
            }

        }
        catch (InputMismatchException e) //catching if they don't input a number
        {
            System.out.println("You did not enter a number. Number of rings" +
                               " has been set to the default 5.");
            answer = 5;
        }

        keyboard.nextLine();

        //create game
        Towers newgame = new Towers(answer);
        newgame.displayTowers(); //display the towers

        //this loop runs the game and quits if quit is equal to false
        while (quit == false)
        {
            //get user input to move ring
            System.out.print("From which tower would you like to move a ring?");
            try
            {
                startPeg = keyboard.nextInt();
                startPeg = (startPeg - 1);
                while (startPeg < 0 || startPeg > 2) //validate input
                {
                    System.out.print("Invalid tower, please enter another number:");
                    startPeg = keyboard.nextInt();
                    startPeg = (startPeg - 1);
                }
            }
            catch (InputMismatchException e) //catching if they don't input a number
            {
                System.out.println("You did not enter a number. You will be " +
                                   "moving from Tower 1");
                startPeg = 0;
            }
            
            keyboard.nextLine();

            //get user input where to move
            System.out.print("Which tower would you like to move it to?");
            try
            {
                endPeg = keyboard.nextInt();
                endPeg = (endPeg - 1);
                    while (endPeg < 0 || endPeg > 2) //validate input
                    {
                    System.out.print("Invalid tower, please enter another number:");
                    endPeg = keyboard.nextInt();
                    endPeg = (endPeg - 1);
                    }
            }
            catch (InputMismatchException e) //catching if they don't input a number
            {
                System.out.println("You did not enter a number. You will be " +
                                   "moving to Tower 1");
                endPeg = 0;
            }

            keyboard.nextLine();
            
            //validate that the move is legal
            if (validMove(newgame, startPeg, endPeg))
            {
                newgame.move(startPeg, endPeg);
                newgame.displayTowers();
            }
            else
            {
                System.out.println("I'm sorry but that is not a valid move");
            }

            //creates win condition and quits
            if (newgame.countRings(1) == answer)
            {
                System.out.println("Congratulations you won the game!");
                quit = true;
            }
            else
            {   //check if they want to continue playing
                System.out.print("Would you like to make another move (Y/N)?");
                String input = keyboard.nextLine();
                char response = input.charAt(0);
                if (response != 'Y' && response != 'y')
                {
                    System.out.println("Goodbye");
                    quit = true;
                }
            }
        }

    }

    //private method to validate the requested move
    private static boolean validMove(Towers game, int startPeg, int endPeg)
    {
        //diameter of moving ring
        int diameterStart = game.getTopDiameter(startPeg);
        //diamter of ring on which to be moved
        int diameterEnd = game.getTopDiameter(endPeg);

        //check if the moving ring is larger than the placement ring
        //if the ring is being placed on 0 this is acceptable
        if (diameterStart > diameterEnd && diameterEnd != 0)
        {
            return false;
        }
        else if (game.countRings(startPeg) == 0) //check if start peg has no rings
        {
            return false;
        }
        else if (startPeg == endPeg) //check if moving to and from same peg
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
