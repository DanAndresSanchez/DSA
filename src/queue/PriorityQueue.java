package queue;
import list.*;
public class PriorityQueue<E extends Comparable<E>> implements QueueADT<E> {

	List<E> list = new ArrayList<E>();
	
	@Override
	public void add(E value) {
		list.add(value);
		int added = list.size() - 1;
		int parent = (added - 1)/2;
		
		while (added > 0 && greater(added,parent)) 
		{
			swap(parent,added);
			added = parent; 
			parent = (added-1)/2;
		}
	}

	private void swap(int x, int y)
	{
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
	
	@Override	
	public E peek() {
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public E remove() {
		int avail = 0;
		int last = list.size()-1;
		int bc = biggerChild(0);
		E result = list.get(0);
		while(2*avail+1 <= last && greater(bc,last))
		{
			list.set(avail, list.get(bc));
			avail = bc;
			bc = biggerChild(avail); 
		}
		list.set(avail,list.get(last));
		list.remove(last);
		return result;
	}
	
	private int biggerChild(int parent) 
	{
		int left = 2*parent+1;
		int right = 2*parent+2;
		if (right >= list.size())
			return left;
		if (greater (left,right))
			return left;
		return right;
	}
	
	private boolean greater( int x, int y)
	{
		return list.get(x).compareTo(list.get(y)) > 0;
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void clear() {
		list.clear();
	}

	public String toString() {
		String initial = "[";
		Iterator<E> itty = list.iterator();
		while(itty.hasNext()) 
			initial += itty.next().toString() + ",";
		if(initial.length() == 1)
			return initial + "]";
		String result = initial.substring(0, initial.length() - 1);
		result += "]";
		return result;
	}
}
