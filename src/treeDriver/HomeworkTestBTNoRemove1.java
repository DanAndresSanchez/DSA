package treeDriver;

import tree.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class HomeworkTestBTNoRemove1
{
    
    public static void main(String[] args)
    {
    BinaryTree <String> kids = new BinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.err.println ("isEmpty not correct");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");

    if (kids.isEmpty())
        System.err.println ("isEmpty not correct");
     if (!(kids.containsKey ("sue")))
        System.err.println ("Not correct 1");
     if (kids.containsKey ("jim"))
        System.err.println ("Not correct 2");
     if (!(kids.get (new String("susie")).equals ("susie")))
        System.err.println ("Not correct 3");
     if ((kids.get ("joseph") != null))
        System.err.println ("Not correct 4");
     System.out.println ("Testing completed");
      
    }
}
