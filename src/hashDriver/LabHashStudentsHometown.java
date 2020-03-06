package hashDriver;
import hash.*;

/**
 * Test the HashTable
 * 
 * @author (sdb) 
 * @version (Nov 2018)
 */
public class LabHashStudentsHometown
{
    public static void main(String[] args)
    {   
         HashTable <Student> students = new HashTable <Student> (10);
      
         students.put (new Student ("jim", "423", 25, new HomeTown ("Glassboro", "NJ", "08028")));
         students.put (new Student ("joe", "424", 32, new HomeTown ("Glassboro", "NJ", "08028")));
         students.put (new Student ("jim", "433", 120, new HomeTown ("Pitman", "NJ", "08028")));
         students.put (new Student ("mary", "443", 0, new HomeTown ("Elk", "NJ", "08018")));
         students.put (new Student ("jim", "501", 25, new HomeTown ("Glassboro", "NJ", "08028")));
         
         Student key = new Student ("jim", "", 25, new HomeTown ("", "", "08028"));
         Student st = students.get (key);
         System.out.println ("Retrieving " + key + ": " + st);
        }
}