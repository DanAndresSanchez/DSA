package hash;

import list.Iterator;

/**
 * An iterator for HashTables
 * @author Dan Sanchez
 *
 */
public class TableIterator<K> implements Iterator<K> {
	HashTable<K> hash;
	int index = 0;		//which linked list we are in
	Iterator<K> itty;	//iterator for the linked list
		
	public TableIterator(HashTable<K> hash) {
		this.hash = hash;
		setItty(0);
	}
	
	private void setItty(int index) {
		itty = (Iterator<K>) hash.table.get(index).iterator();
	}

	@Override
	public boolean hasNext() {
		if(itty.hasNext())
			return true;
		return nextList() > 0;
	}
	
	/**
	 * @return the index of the non empty list or -1 if non
	 */
	private int nextList() {
		for(int i = index + 1; i < hash.table.size(); i++)
			if(!(hash.table.get(i).isEmpty()))
					return i;
		return -1;
	}

	@Override
	public K next() {
		if(itty.hasNext())
			return itty.next();
		index = nextList();
		setItty(index);
		return itty.next();
	}

	@Override
	public void remove() {
		itty.remove();
		hash.size--;
	}

	@Override
	public void add(K value) {
		// TODO Auto-generated method stub
	}

}
