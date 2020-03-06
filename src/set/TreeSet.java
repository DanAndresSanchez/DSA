package set;
import list.Iterator;
import tree.BinarySearchTree;
import tree.BinaryTree;

/**
 * A set using a Binary Search Tree. Values can be obtained in their natural order.
 * @author Dan Sanchez
 */
public class TreeSet<E extends Comparable<E>> implements Set<E> {
	BinaryTree<E> tree = new BinarySearchTree<>();
	int size = 0;
	
	@Override
	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}

	@Override
	public boolean add(E value) {
		if(contains(value))
			return false;
		tree = tree.add(value);
		size++;
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if(!contains(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new TreeSetIterator<>(this);
	}
	
	public int size() {
		return size;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof TreeSet))
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
		Set<E> result = new TreeSet<E>();
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
