package list;

public interface List<E> {
	/**
	 * @param index 
	 * @return 
	 */
	E get(int index);
	
	/**
	 * @param index
	 * @param value
	 * @return
	 */
	E set(int index, E value);
	
	/**
	 * @param value
	 */
	void add(E value);
	
	/**
	 * @param index
	 * @param value
	 */
	void add(int index, E value);

	/**
	 * @param index
	 * @return
	 */
	E remove(int index);
	
	boolean remove(E obj);
	
	/** @return the size of this list */
	int size();
	 

	/** @return true only if this List is empty */
	boolean isEmpty();
	 

	/** Clear this List  */
	void clear();
	
	/** @return the position of the first occurrence of the given Object in this List,
    or -1 if it is not in this List  */
	int indexOf (E obj);
	
	/** @return true only if the given Object is in this List */
	boolean contains (E obj);
	
	/**
	 * @return an Iterator for this list
	 */
	Iterator<E> iterator();
	
	/**
	 * @return a ListIterator for this List, starting at beginning
	 */
	ListIterator<E> listIterator();
	
	/**
	 * @param start- starting position. 0 <= start <= size
	 * @return a ListIterator for this List, starting at the given start position
	 */
	ListIterator<E> listIterator(int start);
	
	/** Insert the given values at the given index.
    Post:  value1 is at position ndx, and value2 is at position ndx+1
	 */
	void add (int index, E value1, E value2);
	
	/** @return true only if the parameter obj is a List and contains the same elements (in the same sequence) as this List. */
	boolean equals (Object obj);
}
