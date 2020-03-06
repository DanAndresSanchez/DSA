package set;
import list.Iterator;

/**
 * A collection with no required ordering, no duplicates
 * @author Dan Sanchez
 *
 * @param <E>
 */
public interface Set<E> {
	
	/**
	 * @param obj wanting to be checked
	 * @return true iff the object is in the set
	 */
	boolean contains(Object obj);
	
	/**
	 * Add the given value to the set
	 * @return true iff value was added
	 */
	boolean add(E value);
	
	/**
	 * Remove the given object given by the obj in the Set
	 * @return true iff it was removed
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator for the set
	 */
	Iterator<E> iterator();

	/** @return true iff obj is a Set which contains the same values as 
	 this Set, and only those values which are in this Set*/
	boolean equals (Object obj);

	int size();
	
    /** @return the Set which is the intersection of this Set with the other Set */
    Set < E>  intersection (Set < E> other);
}
