package sort;
import list.*;

/*
 * Sort a LinkedList in O(n^2)
 */
public class BubbleSortLinked<E extends Comparable<E>> implements Sorter<E>{

	List<E> list;
	
	@Override
	public void sort(List<E> list) {
		this.list = list;
		E left, right;
		ListIterator<E> itty;
		for(int i = 0; i < list.size() - 1; i++) {
			itty = list.listIterator();
			right = itty.next();
			for(int j = 0; j < list.size() - i - 1; j++) {
				left = right;
				right = itty.next();
				if(left.compareTo(right) > 0) {
					itty.remove();
					itty.previous();
					itty.add(right);
					right = itty.next();
				}
			}
		}			
	}

}
