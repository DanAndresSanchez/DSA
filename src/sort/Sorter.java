package sort;

import list.List;

/*
 * Arrange the values in a List in ascending order
 */
public interface Sorter<E extends Comparable<E>> {
	
	void sort(List<E> list);
}
