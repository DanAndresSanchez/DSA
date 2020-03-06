package listDriver;
import list.*;

/**
 * Lab 1
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2018)  
 */
public class DriverArrayList
{
/**
 *  This main method tests the List classes
 *  for lab 1, Data Structures and Algorithms
 */
    public static void main ( String[] args)
    {   List<String> friends = new ArrayList <String> ();

        System.out.println ("Testing problem 2");
    friends.add ("joe");
    friends.add ("mary");
    friends.add ("jim");
    friends.add ("joe");                            // Lists may contain duplicate elements
    friends.add (2, "sally");                       // Insert at position 2
    friends.remove (0);                             // Remove joe at position 0 
    if (friends.size() != 4)
        System.err.println ("Error in add, remove or size");
    String s1 = "sal";
    String s2 = "ly";       // s1 + s2 is "sally"
    System.out.println ("sally is at position " + friends.indexOf(s1 + s2));  // should be 1
    if (friends.indexOf(s1+s2) != 1)
        System.err.println ("Error in indexOf"); 
    if  (friends.contains ("Jim"))
        System.err.println ("Not correct"); 
    if (!friends.contains ("jim"))
        System.err.println ("Not correct"); 
    friends.add ("mary");
     
    if (friends.indexOf("mary") != 0)
        System.err.println ("Not correct");
  
        
////////////// Uncomment the following when ready for problem 3 
     System.out.println ("\n\n Testing problem 3");   
     System.out.println ("The list of friends is " + friends.toString());
     friends.clear();
     if (! friends.isEmpty())
             System.err.println ("Error in clear or isEmpty");
     for (int i=0; i< 25; i++)
             friends.add ("str" + i);
     System.out.println (friends.toString());
     friends.add(1, "x", "y");
     System.out.println (friends.toString());
     friends.add(17, "X", "Y");
     System.out.println (friends.toString());
     friends.add(21, "Hello", "There");
     System.out.println (friends.toString());
     }
}

