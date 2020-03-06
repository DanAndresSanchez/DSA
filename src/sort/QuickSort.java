package sort;

import list.List;

/*
 * Sort a quick sort algorithm. The list should be an ArrayList
 */
public class QuickSort<E extends Comparable<E>> implements Sorter<E>{

	List<E> list;
	int amount = 0;
	
	@Override
	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size() - 1);
	}
	
	/*
	 * Sort the part of the list from start to end inclusive
	 */
	private void qSort(int start, int end) {
		if(end - start < 1)
			return;
		
		int p = partition(start, end);    //position of pivot
		
		qSort(start,p - 1); //sorts the left side of the list
		qSort(p + 1, end);  //sorts the right side of the list
	}
	
	/*
	 * Choose first value as pivot
	 * Post: all values to the left are smaller
	 * Post: all values to the right are greater or equal to
	 * @return the position of pivot 
	 */
	private int partition(int start, int end) {
		int swap = (end + start) / 2;
		E temp = list.get(start);
		list.set(start,list.get(swap));
		list.set(swap, temp);
		
		
		 int p  = start;           //position of pivot in list
		// System.out.println("Start: " + start);
		 E pivot = list.get(p);    //value of pivot
		// System.out.println("Pivot: " + pivot);
		 
		 for(int i = start + 1; i <= end; i++) {
			 if(list.get(i).compareTo(pivot) < 0) {
				 list.set(p, list.get(i));
				 p++;
				 list.set(i, list.get(p));
			 }
		 }
		 
		 amount++;
		 //System.out.println(amount);
		 list.set(p, pivot);
		 return p;
	}
}
