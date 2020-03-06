package tree;

import list.Iterator;

/**
 * Binary tree may have a value and two children
 * @author Dan Sanchez
 *
 * @param <E>
 */
public interface BinaryTree<E> {

	/**
	 * @return the value of this binary tree
	 */
	E getValue();
	
	/**
	 * Search the family of the binary tree for a given value
	 * @param value that wants to be found
	 * @return the value that is found or null if not found
	 */
	E get(E value);
	
	/**
	 * Add the given value to this binary tree
	 * @param value that wants to be added
	 * @return a reference to the resulting tree
	 */
	BinaryTree<E> add(E value);
	
	/**
	 * @param obj that is being checked
	 * @return true if the binary tree contains the given object
	 */
	boolean containsKey(Object obj);
	
	/**
	 * Search this binary tree for a given object and remove it, if possible
	 * @param obj wanted to be removed
	 * @return a reference to the resulting tree
	 */
	BinaryTree<E> remove(Object obj);
	
//	BinaryTree<E> getLeft();
//	
//	BinaryTree<E> getRight();
	
	/** @return true if this BinaryTree is empty */
	boolean isEmpty();
	
	/** @return the number of values in the family of this BinaryTree */
	int size();
	
	/**
	 * @return an Iterator for this binary tree
	 */
	Iterator<E> iterator();
	
	String toString();
	
	/** @return true only if this BinaryTree is equal to obj */
	boolean equals(Object obj);
}
