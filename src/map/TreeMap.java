package map;

import list.Iterator;
import map.HashMap.Entry;
import set.HashSet;
import set.Set;
import tree.*;

/**
 * A map in which the entries are stores in a BST
 * @author Dan Sanchez
 *
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K,V> {
	
	//Beginning of Entry class
	class Entry<K,V> implements Comparable<Entry<K,V>>{
		K key;
		V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public int compareTo(Entry<K, V> other) {
			Comparable thisKey = (Comparable)key;
			Comparable otherKey = (Comparable)other.key;
			return thisKey.compareTo(otherKey);
		}
		
	}
	//end of Entry class
	
	
	//parameters for TreeMap
	BinaryTree<Entry<K,V>> tree = new BinarySearchTree<Entry<K,V>>();
	int size = 0;
	
	@Override
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key,null);
		return tree.containsKey(entry);
	}

	@Override
	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		return tree.get(entry).value;
	}

	@Override
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K,V> oldEntry = tree.get(newEntry);
		if(oldEntry == null) { //not in the tree already
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	@Override
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		if(entry== null) {
			return null;
		}
		tree = tree.remove(entry);
		size--;
		return entry.value;
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
	}
	
	public String toString() {
		String beginning = "[";
		Iterator<Entry<K,V>> itty = tree.iterator();
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
		Iterator<Entry<K,V>> itty = tree.iterator();
		while(itty.hasNext()) {
			result.add(itty.next().key);
		}
		return result;
	}

}
