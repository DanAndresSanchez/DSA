package stack;

/**
 * A list that is Last-in Last-out
 * @author Dan Sanchez
 *
 */
public interface StackADT<E> {

	/**
	 * puts the given value at the given stack
	 * @param value that will be pushed
	 * @return the value that you pushed
	 */
	E push(E value);
	
	/**
	 * Pre: stack is not empty
	 * @return the value on top of the stack
	 */
	E peek();
	
	/**
	 * Remove the top value from the stack
	 * @return value that was removed
	 * Pre: stack is not empty
	 */
	E pop();
	
	
	/** Clear this StackADT */
	void clear();

	/*
	 * checks is Stack is empty
	 */
	boolean isEmpty();

	/** @return the elements of this StackADT as a String */
	String toString();
}
