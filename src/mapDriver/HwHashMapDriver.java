package mapDriver;
import map.*;

/**
 * Test the HashMap
 * 
 * @author (sdb) 
 * @version (Mar 2017)
 */
public class HwHashMapDriver
{
    public static void main(String[] args)
    {   Map <String, String> names = new HashMap <String, String> ();

        names.put ("sue", "609");
        names.put ("jim", "856");
        names.put ("sarah", "215");
        names.put ("will", "856");
        names.put ("stu", "609");
        names.put ("van", "856");
        names.put ("jim", "215");
        
        if  (names.isEmpty())
          System.err.println ("isEmpty incorrect");
        if  (!names.containsKey("van"))
          System.err.println ("containsKey incorrect");
        if  (names.containsKey("joe"))
          System.err.println ("containsKey incorrect");
        if  (names.size() != 6)
          System.err.println ("size incorrect");  
        if  (!names.get("jim").equals("215"))
          System.err.println ("get (or put) incorrect");  
        
        System.out.println ("sue's area code is " + names.remove ("sue"));  // 609
        if  (names.size() != 5)
          System.err.println ("size (or remove) incorrect");  
        if ( names.get ("sue") != null)
            System.err.println ("get or remove incorrect");
        names.clear();
        if (! names.isEmpty())
            System.err.println ("isEmpty or clear is incorrect");
        names.put ("foo", "000");
        if (!names.get("foo").equals("000"))
            System.err.println ("incorrect");
        
      // Optional:  Implement a toString() method for HashMaps
        System.out.println (names);     // Hint: Entry needs a toString() method
}
  
}