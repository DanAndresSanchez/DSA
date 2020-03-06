package tree;

/**
 * Node has a value and two references to two binary trees
 * @author Dan Sanchez
 *
 */
public class Node<E extends Comparable<E>> {
	E value;
	Node<E> left, right;
	
	Node(E value){
		this.value = value;
	}
	
	Node(E value, Node<E> left, Node<E> right ){
		this.value = value;
		this.right = right;
		this.left = left;
	}
	

	/** 
	 * @return the value of this Node as a String
	 */
	public String toString() {
		return (String)this.value;
	}
}
