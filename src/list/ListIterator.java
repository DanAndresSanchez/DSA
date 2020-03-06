package list;

/**
 * an Iterator that can traverse in both directions
 * @author Dan Sanchez
 *
 */
public interface ListIterator<E> extends Iterator<E> {
	/**
	 * implicit cursor (a^b c)
	 * next() returns value to the right of the cursor
	 */
	
	/**
	 * @return true if there is a value to the left of the implicit cursor
	 */
	boolean hasPrevious();
	
	/**
	 * @return value to left of implicit cursor
	 * Pre: hasPrevious() is true
	 */
	E previous();
	
	/**
	 * remove() will remove the last value obtained by either a previous() or next() call
	 */
	
	/** Insert the given value just prior to the implicit cursor position.  A subsequent call to previous()
    should return the inserted value, and a subsequent call to next() should be unaffected.
	 */
	public void add (E value);	
}
