package list;

/**
 * A ListIterator for ArrayList 
 * Implicit cursor is between positions index and index+1
 * @author Sanchez
 *
 * @param <E>
 */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {
	
	private boolean forward;
	
	
	/**
	 * calls constructor from superclass
	 * @param list
	 */
	ArrayListIterator(List<E> list){
		super(list);
		forward = true;
	}
	
	ArrayListIterator(List<E> list, int start){
		super(list);
		forward = true;
		index = start - 1;
	}
	
	public E next() {
		forward = true;
		return super.next();
	}
	
	public boolean hasPrevious() {
		return index >= 0;
	}
	
	public E previous() {
		forward = false;
		index--;
		return theList.get(index + 1);
	}
	
	public void remove() {
		if(forward) {
			theList.remove(index);
			index--;
		}
		else
			theList.remove(index + 1);
		
	}
}
