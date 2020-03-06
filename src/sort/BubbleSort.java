package sort;
import list.*;

public class BubbleSort<E extends Comparable<E>> implements Sorter<E> {
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		boolean isLoop = false;

		for(int i = 0; i < list.size() - 1; i++) {
				for(int j = 0; j < list.size() - i - 1; j++) 
					if(list.get(j).compareTo(list.get(j + 1)) > 0) {
						isLoop = false;
						swap(j, j + 1);
					}
				if(isLoop)
					return;
				isLoop = true;
		}
	}
	
	private void swap(int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
