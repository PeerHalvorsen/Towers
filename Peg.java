import java.util.ArrayList;

/**
The Peg class creates a Peg object to hold n number of rings
where n must be a number between 1 and 64.
@author Peer Halvorsen
*/
public class Peg
{

    private ArrayList<Integer> rings;

    /**
    The constructor creates a list of rings based on user input
    @param numberRings The number of rings to be added to the list.
    */
    public Peg(int numberRings)
    {
        this.rings = new ArrayList<>();
        if (numberRings > 0)//make sure peg is not an empty peg
        {
            for (int i = 0; i < numberRings; i++)
            {
                Integer ring = (i + 1);
                rings.add(ring);
            }
        }
    }

    /**
    Gets the current number of rings in the list
    @return The number of rings in the list
    */
    public int getNumberRings()
    {
        return rings.size();
    }

    /**
    Gets the diameter of the the topmost ring in the sequence.
    @return The diameter of the ring at the top or first position.
    */
    public int getDiameter()
    {
        if (rings.isEmpty())//return 0 if peg is empty to avoid exception
        {
            return 0;
        }
        else
        {
            return rings.get(0);
        }

    }

    /**
    Adds a ring to the list in the top or first position.
    @param diam The ring with diameter n.
    */
    public void addRing(int diam)
    {
        Integer diameter = diam;
        rings.add(0, diameter);//places ring at first postion in list
    }

    /**
    Removes the ring at the top or first position.
    */
    public void removeRing()
    {
        rings.remove(0);//remove ring from top position
    }

    /**
    Gets a copy of the list of rings
    @return The list of rings.
    */
    public ArrayList<Integer> getList()
    {
        return copyList();
    }

    //copies the list of rings
    private ArrayList<Integer> copyList()
    {
        ArrayList<Integer> copy = new ArrayList<>();
        if(!rings.isEmpty())
        {   
            //iterate throught the list save elements into copy
            for (int i = 0; i < rings.size(); i++)
            {
                copy.add(rings.get(i));
            }
        }
        return copy;
    }
}
