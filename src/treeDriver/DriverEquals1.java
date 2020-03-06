package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * Test equals (Object) 
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class DriverEquals1
{
    
    public static void main(String[] args)
    {
    BinaryTree <String> kids = new BinarySearchTree <String> ();
    BinaryTree <String> friends = new  BinarySearchTree <String> ();
    
    if (! kids.equals(friends))
        System.err.println ("Not correct 4");
  
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");
  
    if (kids.equals ("kids"))
        System.err.println ("Not correct 5");
        
    
    if (kids.equals (friends))
        System.err.println ("Not correct 6");
     if (friends.equals (kids))
        System.err.println ("Not correct 7");
        
    friends = friends.add ("kimmy");
    friends = friends.add (new String ("jim" + "my"));
    friends = friends.add ("susie");
    friends = friends.add ("joe");
 
    if (kids.equals (friends))
        System.err.println ("Not correct 8");
     if (friends.equals (kids))
        System.err.println ("Not correct 9");
    
    friends = friends.add ("sue");
 
    if (!kids.equals (friends))
        System.err.println ("Not correct 10");
     if (!friends.equals (kids))
        System.err.println ("Not correct 11");
        
  
  
  kids = new BinarySearchTree<String> ();
  kids = kids.add ("kimmy");
  kids = kids.add ("susie");
  kids = kids.add ("al");
  friends = new BinarySearchTree<String> ();
  friends = friends.add("kimmy");
  friends = friends.add ("al");
  friends = friends.add ("susie2");
  if (friends.equals(kids))
    System.err.println ("Not correct 15");
  if (kids.equals (friends))
    System.err.println ("Not correct 16");

  System.out.println ("Testing completed");
     }  
}