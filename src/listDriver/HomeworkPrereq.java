package listDriver;

import java.util.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Sep 2018)
 */
public class HomeworkPrereq
{   static Random rand = new Random();      // Random number generator
    static final int MAX = 1000000;
    
    public static void main(String[] args)
    {   
        List<Integer>numbers = new  LinkedList<Integer>();    // fix this statement
        init (numbers);
        insertions(numbers, MAX/10);
        System.out.println ("Zeros have been inserted");
    
        numbers = new   LinkedList<Integer>();                 // fix this statement
        init (numbers);
        //if (search(numbers, 199) < 0)
        //       System.out.println ("199 not found in the list");
               
        Set<Integer> evens = new HashSet<Integer>(numbers);
        // Initialize the set from the list of numbers.
    	   
        // Remove the odd numbers
        removeOdds(evens);            
    }
  
    /** Initialize the given list with several
     *  random integers.
     */
    private static void init(List<Integer> numbers)
    {   
        for (int i=0; i<MAX; i++)
            numbers.add (rand.nextInt());
    }
    
    /** Insert zeros at the beginning of the given list
     */
    private static void insertions(List<Integer> numbers, int numberOfZeros)
    {   for (int i=0; i<numberOfZeros; i++)
            numbers.add(0,0);
    }
    
    /** Search the given list for the given target value
       @return position, or -1 if not found.
       */
    private static int search(List<Integer> numbers, int target)
    {   for (int i=0; i<MAX; i++)
            if (numbers.get(i) == target)
                return i;
        return -1;                          // not found
    }
    
    /** Remove all odd numbers from the given set
     */
    private static void removeOdds(Set<Integer> numbers){   
    	Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()){
        	int i = it.next();
        	if(i % 2 != 0) {
        		it.remove();
        		//System.out.println(i);
        	}
           
        }
        System.out.println("Removed all odd numbers");
    }
}

