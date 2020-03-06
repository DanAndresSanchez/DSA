package queue;

import list.*;

/**
 * Head of the LinkedList is the front of the queue
 * 
 * @author Dan Sanchez
 *
 * @param <E>
 */
public class Queue<E> implements QueueADT<E> {

	List<E> values = new LinkedList<E>();

	@Override
	public void add(E value) {
		values.add(value);
	}

	@Override
	public E peek() {
		if (values.isEmpty())
			return null;
		return values.get(0);
	}

	/*
	 * Pre: the queue is not empty
	 * 
	 * @return the value that was removed
	 */
	@Override
	public E remove() {
		return values.remove(0);
	}

	@Override
	public void clear() {
		values.clear();
	}

	@Override
	public boolean isEmpty() {
		if (values.isEmpty())
			return true;
		return false;
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public String toString() {
		return values.toString();
	}

}
