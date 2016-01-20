/*
 * ChainedMap.java
 *
 * Version:
 * $Id: ChainedMap.java,v 1.2 2013/10/15 23:09:47 vxd9797 Exp $
 *
 * Revisions:
 * $Log: ChainedMap.java,v $
 * Revision 1.2  2013/10/15 23:09:47  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/10/15 09:54:03  vxd9797
 * Initial Revision
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ChainedMap class implemented the HashTable with chaining using LinkedList.
 * 
 * @author vxd9797
 */

public class ChainedMap<K, V> {

	// Initial size of the hash table
	public final static int INITIAL_CAPACITY = 8;

	// The maximum load for hash table
	public final static double MAX_LOAD = 0.75;

	// Variable field
	private int numKeys, cap;
	private ArrayList<LinkedList<Node<K, V>>> table;

	/**
	 * Constructor for ChainedMap. Creates the table and fills it with null
	 * values.
	 */
	public ChainedMap() {

		// Create the map with initial capacity
		table = new ArrayList<LinkedList<Node<K, V>>>(INITIAL_CAPACITY);
		cap = INITIAL_CAPACITY;

		// Fill the new map with null
		for (int i = 0; i < cap; i++) {
			table.add(null);
		}
		numKeys = 0;
	}

	/**
	 * Add a (key, value) pair to the map. Invokes rehashing if necessary.
	 * 
	 * @param key
	 *            - Key to add
	 * @param value
	 *            - Value to add
	 */
	public void put(K key, V value) {
		// Get the hashkey
		int hash = (int) (Math.abs(key.hashCode()) % cap);
		Node<K, V> node = new Node<K, V>(key, value);

		// Add the pair to the map
		if (table.get(hash) == null) {
			LinkedList<Node<K, V>> list = new LinkedList<Node<K, V>>();
			list.add(new Node<K, V>(key, value));
			table.set(hash, list);
		} else
			table.get(hash).add(node);
		numKeys++;

		// Calculate the load capacity
		double load = (double) (numKeys) / cap;

		// If the load is higher than max load, then rehash the map
		if (load > MAX_LOAD) {
			rehash();
		}
	}

	/**
	 * Get a (key, value) pair from the map using the key.
	 * 
	 * @param key
	 *            - Key to add
	 */
	public V get(K key) {

		// Get hashkey
		int hash = (int) (Math.abs(key.hashCode()) % cap);

		// If the map is empty, return null
		if (table.get(hash) == null) {
			return null;
		} else {
			for (int i = 0; i < table.get(hash).size(); i++) {
				if (table.get(hash).get(i).getKey().equals(key))
					return table.get(hash).get(i).getValue();
			}
		}
		return null;
	}

	/**
	 * Remove a (key, value) pair from the map using the key.
	 * 
	 * @param V
	 *            value - Value of the removed pair
	 */
	public V remove(K key) {

		int hash = (int) (Math.abs(key.hashCode()) % cap);

		// If the map is empty, return null
		if (table.get(hash) == null) {
			return null;
		} else {
			for (int i = 0; i < table.get(hash).size(); i++) {
				if (table.get(hash).get(i).getKey().equals(key)) {
					return table.get(hash).remove(i).getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Rehash the map by doubling the capacity. Then put all of the pair from
	 * old map to new map.
	 */
	public void rehash() {

		// Create a shallow copy of the old map
		ArrayList<LinkedList<Node<K, V>>> oldList = new ArrayList<LinkedList<Node<K, V>>>(table);

		// Double the capacity
		cap = cap * 2;

		// Create a new map with new capacity
		table = new ArrayList<LinkedList<Node<K, V>>>(cap);

		// Fill null to the new map
		for (int i = 0; i < cap; i++) {
			LinkedList<Node<K, V>> newList = new LinkedList<Node<K, V>>();
			newList = null;
			table.add(newList);
		}

		// Put the pairs from old map to new map
		for (int i = 0; i < oldList.size(); i++) {
			if (oldList.get(i) != null) {
				for (int x = 0; x < oldList.get(i).size(); x++) {
					put(oldList.get(i).get(x).getKey(), oldList.get(i).get(x)
							.getValue());

				}
				
			}

		}

	}

}
