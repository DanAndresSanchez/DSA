package stack;

import list.*;

/**
 * A stackADT using a list
 * @author Dan Sanchez
 *
 */
public class Stack<E> implements StackADT<E>{

	// beginning of list is top of stack
	List<E> values;
	
	public Stack() {
		this(true);
	}
	
	public Stack(boolean arrayBased) {
		if(arrayBased)
			values = new ArrayList<E>();
		else
			values = new LinkedList<E>();
	}
	
	@Override
	public E push(E value) {
		values.add(value);
		return value;
	}

	@Override
	public E peek() {
		return values.get(values.size() - 1);
	}

	@Override
	public E pop() {
		return values.remove(values.size() - 1);
	}

	@Override
	public void clear() {
		values.clear();
	}
	
	@Override
	public String toString() {
		return values.toString();
	}

	@Override
	public boolean isEmpty() {
		if(values.isEmpty())
			return true;
		return false;
	}
	
}
