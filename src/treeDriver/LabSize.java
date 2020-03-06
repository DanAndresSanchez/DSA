package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class LabSize
{
    
    public static void main(String[] args)
    {
    BinaryTree <String> kids = new BinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");

    if (kids.containsKey ("foo"))
        System.err.println ("Error in containsKey");
    if (kids.get("foo") != null)
        System.err.println ("Error in get");
//    // kids = kids.remove ("kimmy");
//       if (kids.containsKey ("kimmy"))
//         System.err.println ("Error in remove");
      if (!kids.containsKey ("joe"))
        System.err.println ("joe should be found in the tree");
      kids = kids.add ("kimmy");
      if (kids.get("kimmy") == null)
        System.err.println ("kimmy not found");
        if (kids.size() != 5)
            System.err.println ("Possible error in size()");
      System.out.println ("Testing complete");
    }
}
