package list;

/**
 * A ListIterator for LinkedLists
 * @author Sanchez
 *
 */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {

	private boolean forward;
	
	RefListIterator(LinkedList<E> list) {
		super(list);
		forward = true;
	}
	
	RefListIterator(LinkedList<E> list, int start) {
		super(list);
		forward = true;
		for(int i = 0; i < start; i++)
			cursor = cursor.next;
	}

	public boolean hasNext() {
		if(theList.isEmpty())
			return false;
		if(forward)
			return cursor.next != theList.tail;
		return true;
	}
	
	public E next() {
		if(forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}

	@Override
	public boolean hasPrevious() {
		if(!forward)
			return cursor.prev != theList.head;
		return cursor != theList.head;
	}

	@Override
	public E previous() {
		if(!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}
	
	public void remove() {
		super.remove();
		if(!forward)
			cursor = cursor.next;
	}
}
