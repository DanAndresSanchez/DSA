package sort;
import list.*;

/*
 * Search an ArrayList for a target
 */
public class BinarySearch<E extends Comparable<E>> {
	
	List<E> list;
	
	public BinarySearch(List<E> list) {
		this.list = list;
	}
	
	/*
	 * @return the position of the given target in the list or -1 if not found
	 */
	public int search(E target) {
		return binSearch(0, list.size() - 1, target);
	}

	private int binSearch(int start, int end, E target) {
		if(start > end)		//target is not in the list
			return -1;
		int m = (start + end) / 2;
		int cmp = target.compareTo(list.get(m));
		if(cmp == m)
			return m;
		if(cmp < 0)
			return binSearch(start, m -1, target);
		return binSearch(m + 1, end, target);
	}
}
