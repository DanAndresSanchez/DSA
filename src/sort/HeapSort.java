package sort;

import list.List;

/**
 * Sort in ascending order, using a heap. The list should be an array list
 * @author Dan Sanchez
 *
 */
public class HeapSort<E extends Comparable<E>> implements Sorter<E> {

	List<E> list;
	
	@Override
	public void sort(List<E> list) {
		this.list = list;
		heapify(0);				//the list is now a heap
		for(int last = list.size() - 1; last > 0; last--) {
			swap(0, last);
			percDown(0,last - 1);
		}
	}
	
	private void swap(int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	/*
	 * Move root down until that part of the list is a heap
	 */
	private void percDown(int root, int max) {
		int bc = biggerChild(root, max);			//position of the roots bigger child
		while(2*root +1 <= max && greater(bc,root)) {
			swap(root,bc);
			root = bc;
			bc = biggerChild(root, max);
		}
	}

	/**
	 * Pre: has a left child
	 * @param root
	 * @return position of root's bigger child
	 */
	private int biggerChild(int root, int max) {
		int left = 2*root + 1;
		int right = 2*root + 2;
		if(right > max)			//No right child
			return left;
		if(greater(left,right))
			return left;
		return right;
	}

	private boolean greater(int x, int y) {
		return list.get(x).compareTo(list.get(y)) > 0;
	}

	/**
	 * Given a list, make it a heap
	 */
	private void heapify(int root) {
		int max = list.size() - 1;
		if(root >= max)
			return;
		heapify(2*root + 1);
		heapify(2*root + 2);
		percDown(root, max);
	}

}
