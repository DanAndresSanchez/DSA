package map;

import set.Set;

/**
 * @author TE
 * Access to data via a key.
 * Keys are unique.
 */
public interface Map<K,V> {
	/** @return true iff the given key is in this Map */
	boolean containsKey(K key);
	
	/** @return the value corresponding to the given key,
	    or null if not in this Map*/
	V get(K key);
	
	/** Put the given (key, value) entry into this Map.
	    @return old value, or null if not in this Map */
	V put(K key, V value);
	
	/** Remove the entry with the given key, if possible.
	    @return value of that entry, or null if not found */
	V remove(K key);
	
	/**  @return the entries in this Map as a String, in the format key=value */
	String toString();

	boolean isEmpty();

	int size();

	void clear();
	
	/** @ return a Set of all the keys in this Map */
	Set< K> keySet();
}
