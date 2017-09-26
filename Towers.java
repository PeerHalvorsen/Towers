import java.util.ArrayList;
import java.util.ListIterator;

/**
The Towers class creates three Tower of Peg objects for the 
Towers of Hanoi game
@author Peer Halvorsen
*/
public class Towers
{
    private ArrayList<Peg> towerpegs; //An ArrayList of the three Peg objects

    /**
    The constructor creates an ArrayList of three Peg objects. The first 
    Peg is instantiated with the number of rings based on user input.
    The second and third Peg objects are empty.
    @param numRings The number of rings to play the game.
    */
    public Towers(int numRings)
    {
        this.towerpegs = new ArrayList<>(3);
        towerpegs.add(new Peg(numRings));
        towerpegs.add(new Peg(0));
        towerpegs.add(new Peg(0));
    }

    /**
    The countRings method returns the current count of rings in Peg n
    @param pegNumber The number of the Peg to count
    @return The count of rings as an int. If the peg is empty return 0.
    */
    public int countRings(int pegNumber)
    {
        Peg pegcount = towerpegs.get(pegNumber);
        int count = pegcount.getNumberRings();
        if (count > 0)//checks if peg is empty
        {
            return count;
        }
        else
        {
            return 0;
        }

    }

    /**
    Gets the diameter of the topmost ring on the Peg n.
    @param pegNumber The number of the Peg
    @return The diameter of the topmost ring as an int. If the Peg is empty
    return 0
    */
    public int getTopDiameter(int pegNumber)
    {
        Peg topDiameter = towerpegs.get(pegNumber);
        int diameter = topDiameter.getDiameter();
        if (diameter > 0) //checks if peg is empty
        {
            return diameter;
        }
        else
        {
            return 0;
        }

    }

    /**
    Makes a move based on user input of the number of the Peg 
    from which to move and the number of the Peg to move to.
    @param startPeg The Peg to move from
    @param endPeg The Peg to move to
    */
    public void move(int startPeg, int endPeg)
    {
        Peg start = towerpegs.get(startPeg);//start peg
        Peg end = towerpegs.get(endPeg);//end peg
        end.addRing(getTopDiameter(startPeg)); //place same diameter ring on end
        start.removeRing();//remove ring from start peg

    }

    /**
    Displays the three towers as output to the terminal 
    by iterating through each list and checking if each list has another
    ring.
    */
    public void displayTowers()
    {
        //creates ListIterator objects for each Peg
        ListIterator list1 = towerpegs.get(0).getList().listIterator();
        ListIterator list2 = towerpegs.get(1).getList().listIterator();
        ListIterator list3 = towerpegs.get(2).getList().listIterator();

        System.out.println("Tower1     Tower2     Tower3");

        while (list1.hasNext() || list2.hasNext() || list3.hasNext())
        {
            //These conditional statements check if each list has another item
            //and provide the appropriate output so as to avoid an exception 
            //in case one of the lists does not have another item
            if (list1.hasNext() && !list2.hasNext() && !list3.hasNext())
            {
                System.out.println("  " + list1.next());
            }
            else if (list1.hasNext() && list2.hasNext() && !list3.hasNext())
            {
                System.out.println("  " + list1.next() + "          "
                        + list2.next());
            }
            else if (list1.hasNext() && list2.hasNext() && list3.hasNext())
            {
                System.out.println("  " + list1.next() + "          "
                        + list2.next() + "          "
                        + list3.next());
            }
            else if (!list1.hasNext() && list2.hasNext() && list3.hasNext())
            {
                System.out.println("             " + list2.next()
                        + "          " + list3.next());
            }
            else if (!list1.hasNext() && !list2.hasNext() && list3.hasNext())
            {
                System.out.println("                        "
                        + list3.next());
            }
            else if (!list1.hasNext() && list2.hasNext() && !list3.hasNext())
            {
                System.out.println("             " + list2.next());
            }
            else
            {
                System.out.println("  " + list1.next() + "                     "
                        + list3.next());
            }
        }

    }

}
