package listDriver;
import list.*;

/**
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2018)  
 */
public class DriverLinkedList
{
/**
 *  This main method tests the LinkedList class
 */
    public static void main (String[] args )
    {   List<String> friends = new LinkedList <String> ();

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
//    System.out.println ("sally is at position " + friends.indexOf(s1 + s2));  // should be 1
//    if (friends.indexOf(s1+s2) != 1)
//        System.err.println ("Error in indexOf"); 
    if  (friends.contains ("Jim"))
        System.err.println ("Not correct");  
     
    if (friends.indexOf("mary") != 0)
        System.err.println ("Not correct");
  
    System.out.println ("The list of friends is " + friends);
    friends.clear();
    if (! friends.isEmpty())
            System.err.println ("Error in clear or isEmpty");
    for (int i=0; i< 25; i++)
            friends.add ("str" + i);
    System.out.println (friends);
    friends.add(1, "x", "y");
    System.out.println (friends.toString());
    friends.add(17, "X", "Y");
    System.out.println (friends.toString());
    friends.add(21, "Hello", "There");
    System.out.println (friends.toString());
    
    // Uncomment the following lines when ready for problem 3
     System.out.println ("\nTesting problem 3");
     friends.add("str3");
     if (friends.indexOf(new String("str3")) != 3)
         System.err.println ("Error in indexOf");
//     if (friends.remove("foo"))
//         System.err.println ("Error in remove(Object)");
     for (int i=0; i<100; i = i+2)   // remove even values
         friends.remove(new String("str"+i));
     if (friends.size() != 13)
         System.err.println ("Error in remove(Object)");
     System.out.println (friends);

     }
}       
