package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Sep 2018)
 */
public class HomeworkLinkedList1Driver
{
    public static void main(String[] args)
    {   
    List <String> names;
    System.out.println ("Testing LinkedLists");
    names = new LinkedList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   
   System.out.println (names.get(2));  // Should be joe
   names.set (2, "Joe");            
   System.out.println (names.get(2));  // Should be Joe
   
   names.add(0,"emmy");
   names.add(5,"zoe");
   System.out.println (names.size());  // Should be 6
   System.out.println (names.get(1));   // should be jim
   System.out.println (names.remove (0));   // should be emmy
   System.out.println (names.size());  // Should be 5
   System.out.println (names.get(2));  // Should be Joe
   System.out.println (names.toString());
   
   if (names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty");
   names.clear();
   if (!names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty or clear");
   names.add ("sue");
   System.out.println (names.get(0));   // should be sue
   System.out.println (names.indexOf("sue"));  // Should be 0
   System.out.println (names.contains("joe"));  // Should be false
   System.out.println (names.contains("sue"));  // Should be true
   System.out.println (names.toString());
   
   
}
  
}
