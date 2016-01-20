/*
 * Node.java
 *
 * Version:
 * $Id: Node.java,v 1.2 2013/10/15 23:09:47 vxd9797 Exp $
 *
 * Revisions:
 * $Log: Node.java,v $
 * Revision 1.2  2013/10/15 23:09:47  vxd9797
 * Final Version
 *
 * Revision 1.1  2013/10/15 09:54:03  vxd9797
 * Initial Revision
 *
 */

/**
 * Node class which contains the entries for LinkedList.
 * 
 * @author vxd9797
 */

public class Node<K, V> {
	
	// Variables field
	private K key;
	private V value;
	
	/**
	 * Constructor for node.
	 * Accept a key and value.
	 * 
	 * @param K key and V value
	 */
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Accessor for key.
	 * 
	 * @return K key
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * Accessor for value.
	 * 
	 * @return V value
	 */
	public V getValue() {
		return value;
	}
	
	/**
	 * Display the String presentation of the Node.
	 * 
	 * @return String
	 */
	public String toString() {
		return "Key: " + key + " Value: " + value;
	}

}
