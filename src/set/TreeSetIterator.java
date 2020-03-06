package set;
import tree.BinarySearchTree;
import tree.TreeIterator;

/**
 * An iterator for the TreeSets
 * @author Dan Sanchez
 */
public class TreeSetIterator<E extends Comparable<E>> extends TreeIterator<E>{
	TreeSet<E> set;
	
	public TreeSetIterator(TreeSet<E> set) {
		super((BinarySearchTree<E>) set.tree);
		this.set = set;
	}

	//hasNext() and next() are inherited from TreeIterator
	
	public void remove() {
		//super.remove();
		set.tree = set.tree.remove(lastGotten());
		set.size--;
	}
}
