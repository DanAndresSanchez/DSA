package queue;
import list.*;

public class ArrayQueue<E> implements QueueADT<E> {

	List<E> values = new ArrayList<E>();
	int front = 0, back = 0, size = 0;
	
	
	@Override
	public void add(E value) {
		if(values.size() == size) {   //ArrayList full?
			values.add(back, value);
			front = (front + 1) % values.size();
		}
		else
			values.set(back, value);
		size++;
		back = (back + 1) % values.size();
	}


	@Override
	public E peek() {
		if(size == 0)
			return null;
		return values.get(front);
	}

	@Override
	public E remove() {
		E result = values.get(front);
		front = (front + 1) % values.size();
		size--;
		return result;
	}

	@Override
	public void clear() {
		values.clear();
	}

	@Override
	public boolean isEmpty() {
		if(values.isEmpty())
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
