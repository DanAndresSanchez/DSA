package list;

class ArrayIterator<E> implements Iterator<E>{

	//position of item last obtained by call to next
	int index = -1;
	List<E> theList;
	
	ArrayIterator(List<E> list){
		theList = list;
	}
	
	@Override
	public boolean hasNext() {
		return index < theList.size() - 1;
	}

	@Override
	public E next() {
		index++;
		return theList.get(index);
	}

	@Override
	public void remove() {
		theList.remove(index);
		index--;
	}

	public void add (E value) {
		theList.add(value);
		index++;
	}
}
