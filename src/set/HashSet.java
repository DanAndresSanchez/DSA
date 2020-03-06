package set;
import hash.HashTable;
import list.Iterator;

/**
 * An implementation of Set, using a HashTable.
 * The type E class should have a hashCode method defined
 * @author Dan Sanchez
 */

public class HashSet<E> implements Set<E>{
	HashTable<E> table = new HashTable<E>();

	@Override
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}

	@Override
	public boolean add(E value) {
		if(contains(value))
			return false;
		table.put(value);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		return table.remove((E) obj);
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) table.iterator();
	}
	
	public int size() {
		return table.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Set))
			return false;
		Set<E> other = (Set<E>)obj;
		if(this.size() != other.size())
			return false;
		Iterator<E> itty1 = this.iterator();
		Iterator<E> itty2 = other.iterator();
		
		while(itty1.hasNext()) {
			if(!(this.contains(itty2.next())))
				return false;
		}
		return true;
	}

	@Override
	public Set<E> intersection(Set<E> other) {
		Set<E> result = new HashSet<E>();
		Iterator<E> itty = this.iterator();
		while(itty.hasNext()) {
			E check = itty.next();
			if(other.contains(check))
				result.add(check);
		}
		return result;
	}
	
	public String toString() {
		String initial = "[";
		Iterator<E> itty = this.iterator();
		while(itty.hasNext()) 
			initial += itty.next().toString() + ",";
		String result = initial.substring(0, initial.length() - 1);
		result += "]";
		return result;
	}
}
