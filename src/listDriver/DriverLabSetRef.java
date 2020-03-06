package listDriver;
import list.*;

/**
 * Lab 2
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2018)
 */
public class DriverLabSetRef
{
/**
 *  Test the LinkedList class.  Obtaining a reference to a Node
 *  near the end of the list should be efficient.
 */
    public static void main (String[] args )
    {   
        System.out.println ("Testing problem 1");
        List<Integer> numbers = new LinkedList <Integer> ();
        for (int i=0; i<100000; i++)
            numbers.add(i);
        
        for (int i=0; i<100000; i++)
            {   int smallNdx = i % 5;
                if (numbers.get(smallNdx) != smallNdx)
                    System.err.println ("Error for " + smallNdx);
                int largeNdx = 100000 - smallNdx - 1;
                if (numbers.get(largeNdx) != largeNdx)
                    System.err.println ("Error for " + largeNdx);
           }
       System.out.println ("Testing complete");
    }

}

