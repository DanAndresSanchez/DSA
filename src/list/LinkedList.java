package list;

/**
 * Implementation of List using references instead of arrays.
 * Efficient in accessing previous values.
 * @author Dan Sanchez
 *
 */
public class LinkedList<E> implements List<E> {
	
		int size = 0;
		Node<E> head = new Node<E>(null, null, null);
		Node<E> tail = new Node<E>(null, null, head);
		private Node<E> ref;
		
	public LinkedList(){
		head.next = tail;
	}
	
	public LinkedList(List<E> l){
		Iterator<E> itty = l.iterator();
		while(itty.hasNext()) {
			E next = (E)itty.next();
			this.add(next);
		}
	}
	
	private void setRef(int index){
		ref = head.next;
		for(int i = 0; i < index; i++){
			ref = ref.next;
		}
	}
	
	private void setRefPrev(int index){
		ref = tail.prev;
		for(int i = 0; i < index; i++){
			ref = ref.prev;
		}
	}
	
	public E get(int index) {
		setRef(index);
		return ref.value;
	}

	@Override
	public E set(int index, E value) {
		setRef(index);
		E result = ref.value;
		ref.value = value;
		return result;
	}

	@Override
	public void add(E value) {
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}

	@Override
	public void add(int index, E value) {
		setRef(index);
		Node<E> temp =  new Node<E>(value, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		temp.next = ref;
		size++;
	}

	@Override
	public E remove(int index) {
		setRef(index);
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return ref.value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	@Override
	public int indexOf(E obj) {
		for(int i = 0; i < size; i++) {
			if(get(i).equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E obj) {
		if(indexOf(obj) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String names = "[";
		for(int i = 0; i < size; i++) {	
			if(i == size - 1) {
				names += get(i) + "]";
			}
			else {
				names += get(i) + ",";
			}
		}
		return names;
	}

	
	@Override
	public boolean remove(E obj) {
		ref = head.next;
		for(int i = 0; i < size; i++) {
			if(ref.value.equals(obj)) {
				ref.prev.next = ref.next;
				ref.next.prev = ref.prev;
				size--;
				return true;
			}
			ref = ref.next;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(){
		return new RefListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start){
		return new RefListIterator<E>(this, start);
	}

	@Override
	public void add(int index, E value1, E value2) {
		setRef(index);
		Node<E> temp =  new Node<E>(value1, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		temp.next = ref;
		size++;
		
		setRef(index + 1);
		Node<E> temp1 =  new Node<E>(value2, ref, ref.prev);
		ref.prev.next = temp1;
		ref.prev = temp1;
		temp1.next = ref;
		size++;
	}
	
	public boolean equals (Object obj) {;
	List<E> compList;
	if(obj instanceof List)
		compList = (List) obj;
	else
		return false;
	
	Iterator thisItty = this.iterator();
	Iterator compItty = compList.iterator();
	
	if(this.size == compList.size()) {
		while(thisItty.hasNext()) {
			if(!(thisItty.next().equals(compItty.next())))
				return false;
		}
		return true;
	}
	else 
		return false;
}
}
