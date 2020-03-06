package tree;
import list.*;
import queue.*;

/**
 * An inorder traversal for a binary search tree
 * @author Dan Sanchez
 *
 */
public class TreeIterator<E extends Comparable<E>> implements Iterator<E> {
	BinaryTree<E> tree;
	QueueADT<E> queue = new Queue<E>();
	E lastGotten;                            //last value obtained by next
	
	public TreeIterator(BinarySearchTree<E> tree) {
		this.tree = tree;
		buildQ(tree.root);
	}
	
	public E lastGotten() {
		return lastGotten;
	}

//	/**
//	 * Inorder traversal
//	 * @param root
//	 */
//	private void buildQ(Node<E> root) {
//		// TODO Auto-generated method stub
//		if(root == null)
//			return;
//		buildQ(root.left);
//		queue.add(root.value);
//		buildQ(root.right);
//	}
	
	/**
	 * PostOrder Traversal
	 * @param root
	 */
	private void buildQ(Node<E> root) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		buildQ(root.left);
		buildQ(root.right);
		queue.add(root.value);
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public E next() {
		return lastGotten = queue.remove();       //assignment returns a value. will call queue,remove and assign it to lastGotten
												  // and the assignment( = ) returns lastGotten
	}

	@Override
	public void remove() {
		BinarySearchTree<E> tree = (BinarySearchTree<E>)this.tree;
		if(tree.root.left != null && tree.root.right != null || !tree.getValue().equals(lastGotten)) {
			this.tree = tree.remove(lastGotten);
			return;
		}
		
		if(tree.root.left != null)
			tree.root = tree.root.left;
		else
			tree.root = tree.root.right;
	}

	@Override
	public void add(E value) {
		// TODO Auto-generated method stub
		
	}
}
