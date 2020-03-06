package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Nov 2018)
 */
public class LabToStringInOrder1
{
    
    public static void main(String[] args )
    {
    BinaryTree <String> kids = new BinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("jo");  //
    kids = kids.add ("sue");
    kids = kids.add ("al");

    // Inorder sequence
    System.out.println ("Inorder\n" + kids + "\n");      // Lab problem
   
        // InOrder traversal
    System.out.println ("InOrder");
    Iterator<String> itty = kids.iterator();
    while (itty.hasNext())
        System.out.print (itty.next() + " ");
    System.out.println ("\n");
        
        
     System.out.println();
//   remove all strings which are longer than 3 chars
     itty = kids.iterator();
     while (itty.hasNext())
        if (itty.next().length() > 3)
            itty.remove();
            
     System.out.println ("\nLong names have been removed");
     itty = kids.iterator();
     while (itty.hasNext())
        System.out.print (itty.next() + " ");     // Should be  [al,jo,joe,sue]
System.out.println ("\n" + kids);
        
     
    }
}