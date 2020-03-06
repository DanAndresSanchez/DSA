package tree;

import list.*;

/**
 * A binary tree on which all values to the left are smaller, right children are bigger
 * @author Dan Sanchez
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

	Node<E> root;  //if is empty, implies that this tree is empty
	
	public BinarySearchTree(E value) {
		root = new Node<E>(value);
	}
	
	public BinarySearchTree() {} //compiler does not provide default constructor
	
	@Override
	public E getValue() {
		return root.value;
	}
	
	public Node<E> getRoot(){
		return root;
	}

	@Override
	public E get(E value) {
		if(root == null)
			return null;
		Node<E> node = root;
		int cmp;
		while(node != null) {
			cmp = value.compareTo(node.value);
			if(cmp == 0)
				return node.value;
			if(cmp < 0)
				node =  node.left;
			if(cmp > 0)
				node = node.right;
		}
		return null;
	}

	@Override
	public BinaryTree<E> add(E value) {
		if (root == null)
            return new BinarySearchTree< E> (value);
	    Node < E> node = root;
	    int cmp;
	    while (node != null){
	    	cmp = value.compareTo (node.value);
	        if (cmp == 0)
	            return this;
	        if (cmp < 0)
	            if (node.left == null) {
	                node.left = new Node< E> (value);
	                return this;
	            }
	            else 
	            	node = node.left;
	        if (cmp > 0)
	            if (node.right == null) {
	               node.right = new Node < E> (value);
	                  return this;
	            }
	          else node = node.right;
	     }
	     return this;
	}

	@Override
	public boolean containsKey(Object obj) {
		try {
			E value = (E)obj;
			Node<E> node = root;
			int cmp;
			while(node != null) {
				cmp = value.compareTo(node.value);
				if(cmp == 0)
					return true;
				if(cmp < 0)
					node =  node.left;
				if(cmp > 0)
					node = node.right;
			}
		}
		catch(ClassCastException cce) {
			return false;
		}
		
		return false;
	}

	@Override
	public BinaryTree<E> remove(Object obj) {
		if(isEmpty())
			return null;
		try {
			E value = (E)obj;
			Node<E> node = root, parent = null;
			int cmp;
			while(node != null) {
				cmp = node.value.compareTo(value);
				if(cmp == 0) {                                        //found value in tree
					List<Node<E>> kids = children(node);
					if(kids.size() == 0)   							  //no children
						if(node == root)
							root = null;
						else if(parent.value.compareTo(value) < 0)
							parent.right = null;	
						else
							parent.left = null;
					if(kids.size() == 1)
						if(node == root)            				  //one child
							root = kids.get(0);
						else
							if(parent.value.compareTo(value) < 0)
								parent.right = kids.get(0);
							else
								parent.left = kids.get(0);
				    if(kids.size() == 2)
				    	node.value = remove(node);      			  //different methods, not recursive
				    return this;  
				} 
				parent = node;
				if(cmp < 0)
					node = node.right;
				if(cmp > 0)
					node = node.left;	
			}//end of loop
		}//end of try block
		catch(ClassCastException cce) {}
		return this;
	}

//	@Override
//	public BinaryTree<E> getLeft() {
//		if(root.left == null)
//			return null;
//		BinarySearchTree<E> result = new BinarySearchTree<E>(root.left.value);
//		result.root.left = root.left.left;
//		result.root.right = root.left.right;
//		return result;
//	}
//
//	@Override
//	public BinaryTree<E> getRight() {
//		if(root.right == null)
//			return null;
//		BinarySearchTree<E> result = new BinarySearchTree<E>(root.right.value);
//		result.root.left = root.right.left;
//		result.root.right = root.right.right;
//		return result;
//	}

	@Override
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		  return(Size(root)); 
	}
	
	private int Size(Node<E> node) { 
		if (node == null) 
			return(0); 
		return (Size(node.left) + Size(node.right)) + 1; 
	} 

	private List<Node<E>> children(Node<E> node){
		List<Node<E>> result = new ArrayList<Node<E>>();
		if(node.left != null)
			result.add(node.left);
		if(node.right != null)
			result.add(node.right);
		return result;
	}
	
	/**
	 * Remove the successor of the given node
	 * pre: node has 2 children
	 * @return successor's value
	 */
	private E remove(Node<E> node) {
		Node<E> successor = node.right, succParent = node;
		if(successor.left == null) {
			node.right = successor.right;
			return successor.value;
		}
		while(successor.left != null) {
			succParent = successor;
			successor = successor.left;
		}
		succParent.left = successor.right;
		return successor.value;
	}
	
	public Iterator<E> iterator(){
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		String result = "";
		TreeIterator<String> itty = (TreeIterator<String>) this.iterator();
		while(itty.hasNext()) {
			result += itty.next() + ",";
		}
		String s = result.substring(0, result.length() - 1);
		return "[" +  s +  "]";
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof BinaryTree))
			return false;
		if(this.isEmpty() && ((BinarySearchTree<E>)obj).isEmpty())
			return true;
		if(this.size() != ((BinarySearchTree<E>)obj).size())    //do not have same size
			return false;
		if(!(this.toString().equals(obj.toString())))     //do not have same elements
			return false;
		
		if(!(check(root, ((BinarySearchTree<E>)obj).root)))
			return false;

		return true;
	}
	
	private boolean check(Node<E> node1, Node<E> node2) {
		if(!(node1.value.equals(node2.value)))
			return false;

		if(node1.left.value.equals(node2.left.value) && node1.right.value.equals(node2.right.value))
			return true;
		
		boolean left = check(node1.left, node2.left);
		boolean right = check(node1.right, node2.right);

		return left && right;
	}
}

