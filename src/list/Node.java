package list;

public class Node<E> {
	E value;
	Node<E> next;
	Node<E> prev;
	
	//for LinkedList that isn't doubly
	Node(E val, Node<E> n){
		value = val;
		next = n;
	}
	
	//for doubly LinkedList
	Node(E val, Node<E> n, Node<E> p){
		value = val;
		next = n;
		prev = p;
	}
}
