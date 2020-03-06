package map;
import hash.*;
import list.Iterator;
import set.HashSet;
import set.Set;

/**
 * @author Dan Sanchez
 * A Map implemented with a HashTable
 */
public class HashMap<K,V> implements Map<K,V>{
	
	class Entry<K,V> {
		K key;
		V value;
		
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public boolean equals(Object obj) {
			Entry other = (Entry) obj;
			return key.equals(other.key);
		}
		
		public int hashCode() {
			return key.hashCode();
		}
		
		public String toString() {
			return key.toString() + "=" + value.toString();
		}
	} //end inner class
	
	HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
	
	public HashMap(int cap) {
		table = new HashTable<Entry<K,V>>(cap);
	}
	
	public HashMap() { }
	
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		return table.containsKey(entry);
	}
	
	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value),
				   oldEntry = table.get(newEntry);
		if(oldEntry == null) {
			table.put(newEntry);
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}
	
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		Entry<K,V> result = table.get(entry);
		if(result == null)
			return null;
		table.remove(result);
		return result.value;
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public int size() {
		return table.size();
	}
	
	public void clear() {
		table.clear();
	}
	
	public String toString() {
		String beginning = "[";
		Iterator<Entry<K,V>> itty = table.iterator();
		while(itty.hasNext()) {
			beginning += itty.next().toString() + ", ";
		}
		String result = beginning.substring(0, beginning.length() - 2);
		result += "]";
		return result;
	}

	@Override
	public Set<K> keySet() {
		Set<K> result = new HashSet<K>();
		Iterator<Entry<K,V>> itty = table.iterator();
		while(itty.hasNext()) {
			result.add(itty.next().key);
		}
		return result;
	}
}
