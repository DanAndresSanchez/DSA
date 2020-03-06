package sort;
import javax.swing.JList;

import list.*;

/*
 * Can sort ArrayLists
 */
public class SelectionSort<E extends Comparable<E>> implements Sorter<E> {

	List<E> list;
	
	@Override
	public void sort(List<E> list) {
		// TODO Auto-generated method stub
		this.list = list;
		for(int i = 0; i < list.size() - 1; i++) {
			swap(i, posSmallest(i));
		}
	}
	
	/*
	 * @return the position of the smallest value in the list
	 */
	private int posSmallest(int start) {
		int result = start;
		
		for(int i = start + 1; i < list.size(); i++) {
			if(list.get(i).compareTo(list.get(result)) < 0)
				result = i;
		}
		 return result;	
	}
	
	private void swap(int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
