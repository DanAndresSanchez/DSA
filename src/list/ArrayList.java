package list;

//@author Dan Sanchez
public class ArrayList<E> implements List<E>{
	
	int size = 0;
	E[] values;
	
	public ArrayList() {
		this(10);
	}
	
	public ArrayList(int cap) {
		values = (E[]) new Object[cap] ;
	}
	
	public E get(int index) {
		return values[index];
	}

	public E set(int index, E value) {
		E result = values[index];
		values[index] = value;
		return result;
	}

	public void add(E value) {
		add(size, value);
	}

	public void add(int index, E value) {
		if(size == values.length) 
			alloc();
		for(int i = size; i > index; i--) 
			values[i] = values[i - 1];	
		size++;
		values[index] = value;
	}

	public E remove(int index) {
		E result = values[index];
		for(int i = index; i < size - 1; i++) {
			values[i] = values[i + 1];
		}
		size--;
		return result;
	}
	
	private void alloc() {
		E[] temp = (E[]) new Object[values.length*2];
		for(int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if(size() == 0 ){
			return true;
		}
		else{
			return false;
		}
	}

	public void clear() {
		size = 0;
	}

	public int indexOf(Object obj) {
		for(int i = 0; i < size; i++) {
			if(values[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}

	public boolean contains(Object obj) {
		if(indexOf(obj) > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	/** @return this List as a String  */
	public String toString() {
		String names = "[";
		for(int i = 0; i < size; i++) {
			if(i == size - 1) {
				names += values[i] + "]";
			}
			else {
				names += values[i] + ",";
			}
		}
		return names;
	}

	@Override
	public boolean remove(E obj) {
		int index = indexOf(obj);
		remove(index);
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(){
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start){
		return new ArrayListIterator<E>(this, start);
	}

	@Override
	public void add(int index, E value1, E value2) {
		if(size == values.length) 
			alloc();
		for(int i = size; i > index; i--) 
			values[i] = values[i - 1];	
		size++;
		values[index] = value1;
		
		for(int i = size; i > index + 1; i--) 
			values[i] = values[i - 1];
		values[index + 1] = value2;
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
