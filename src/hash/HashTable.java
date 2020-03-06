package hash;
import list.*;

/**
 * HashTable implemented as a List of Lists. Duplicate values are permitted
 * @author Dan Sanchez
 */
public class HashTable<K> {
	List<List<K>> table;
	int size = 0;   		//number of keys
	
	public HashTable() {
		this(10);		//when debugging, make smaller to make process faster
	}
	
	public HashTable(int cap) {
		table = new ArrayList<List<K>>(cap);
		for(int i  = 0; i < cap; i++) 
			table.add(new LinkedList<K>());
	}
	
	/**
	 * @return true iff given key is in this HashTable
	 */
	public boolean containsKey(Object obj) {
		int code = getCode(obj);
		return table.get(code).contains((K) obj);
	}
	
	/**
	 * @param obj
	 * @return the key which is equal to the given keys, or null if not found
	 */
	public K get(K key) {
		List<K> list = table.get(getCode(key));
		int index = list.indexOf(key);
		if(index == -1)		//not found
			return null;
		return list.get(index);
	}
	
	/**
	 * put given key into this HashTable
	 */
	public void put(K key) {
		int code = getCode(key);
		table.get(code).add(key);
		size++;
	}
	
	/**
	 * Remove the given key from this HashTable if possible
	 * @return true if was removed
	 */
	public boolean remove(K key) {
		int code = getCode(key);
		List<K> list = table.get(code);
		boolean result = list.remove(key);
		if(result)
			size--;
		return result; 
	}
	
	public Iterator<K> iterator(){
		return (Iterator<K>) new TableIterator<K>(this);
	}
	
	/**
	 * @param obj
	 * @return valid index to array list
	 */
	private int getCode(Object obj) {
		int code = obj.hashCode();
		code = Math.abs(code);
		code = code % table.size();
		return code;
	}

	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	public int size() {
		return size;
	}

	public void clear() {
		Iterator<List<K>> itty = table.iterator();
		while(itty.hasNext())
			itty.next().clear();
		size = 0;
	}
}
