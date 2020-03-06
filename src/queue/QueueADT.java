package queue;

public interface QueueADT<E> {
	
	/*
	 * Adds the value at the back of this queue
	 */
	void add(E value);
	
	/**
	 * @return the value at the front of this queue, return null if queue is empty
	 */
	E peek();
	
	/**
	 * removes the valuse at the front of the list
	 * @return the value that was removed
	 */
	E remove();
	
	/** Clear this QueueADT
	 * 
	 */
	void clear();

	 

	/**
	 *  @return true if this Queue is empty 
	 */
	boolean isEmpty();
	
	int size();
	
	String toString();
}
