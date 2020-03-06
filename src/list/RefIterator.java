package list;

class RefIterator<E> implements Iterator<E> {

	LinkedList<E> theList;
	Node<E> cursor;		//reference to the node last obtained by next
	
	RefIterator(LinkedList<E> list){
		theList = list;
		cursor = theList.head;
	}
	
	@Override
	public boolean hasNext() {
		return cursor.next != theList.tail;
	}

	@Override
	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}

	@Override
	public void remove() {
		cursor.next.prev = cursor.prev;
		cursor.prev.next = cursor.next;
		cursor = cursor.prev;
		theList.size--;
	}

	public void add(E value) {
		Node<E> temp =  new Node<E>(value, cursor, cursor.prev);
		cursor.prev.next = temp;
		cursor.prev = temp;
		temp.next = cursor;
		theList.size++;
	}

}
