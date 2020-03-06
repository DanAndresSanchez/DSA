package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the Bubble Sort algorithm
 * on a LinkedList.
 * 
 * @author (sdb) 
 * @version (Oct 2018)
 */
public class HomeworkTestBubbleLinked
{
    static List <Integer> grades;
    static Random rand = new Random();
    static Sorter <Integer> sorter;
    
    public static void main (String[] args)
    {
      
     System.out.println ("Test Bubble Sort on a LinkedList:");
     grades  = new LinkedList <Integer> ();
     sorter = new BubbleSortLinked <Integer>  ( );
     testSort (sorter, false);
     testSort (sorter, true);
     
     System.out.println ("Test Bubble Sort on an ArrayList:");
     grades  = new ArrayList <Integer> ();
     testSort (sorter, false);
     testSort (sorter, true);
     
    }
    
    private static void testSort (Sorter<Integer> sorter, boolean incr)
    {   if (incr)
            init2();
        else
            init();
        
        System.out.println ("Before sorting:");
        System.out.println (grades);
        System.out.println ("After sorting:");
        sorter.sort(grades);
        System.out.println (grades + "\n");
        System.out.println ( );
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<100; i++)
             grades.add (rand.nextInt(150));

    }
    
    // Nearly increasing
    private static void init2()
    {   grades.clear(); 
        for (int i=0; i<10; i++)
             grades.add (i*10);
        grades.add(0,200);
    }

}
