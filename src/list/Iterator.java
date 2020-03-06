package list;
/**
 * An ADT which permits access to each element in collection
 * @author Dan Sanchez
 *
 */
public interface Iterator<E> {
	
	/**
	 * @return true if there are more items
	 */
	boolean hasNext();
	
	/** the next item in list
	 * Precondition - hasNext is true
	 * @return
	 */
	E next();
	
	/**
	 * Removes last item obtained by next
	 * Precondition - next has been called at least once and at least once since last called to remove
	 */
	void remove();

	void add(E value);
}
