package sortDriver;
import sort.*;
import list.*;

public class worstCase {
	public static void main(String[] args) {
		List <Integer> numbers = new ArrayList <Integer> ();
		Sorter<Integer>  sorter;
		sorter = new QuickSort <Integer> ();  
		numbers.add(5);
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		numbers.add(4);
		numbers.add(6);
		
		System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort(numbers);
        System.out.println ("After sorting:");
        System.out.println (numbers);
			
	}
	 
}
