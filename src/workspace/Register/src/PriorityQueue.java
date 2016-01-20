/**
 * PriorityQueue.java
 * 
 * $Id: PriorityQueue.java,v 1.1 2013/09/25 05:13:20 vxd9797 Exp $
 *
 * $Log: PriorityQueue.java,v $
 * Revision 1.1  2013/09/25 05:13:20  vxd9797
 * Initial Revision
 *
 * 
 */

/**
 * 
 * Interface for a generic priority queue.  Does not specify whether
 * small or large priority values are "high" priority.
 * @author zjb
 *
 */
public interface PriorityQueue<T extends Prioritizable> {

	/**
	 * Is there anything in the queue?
	 * @return queue is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Add an item to the queue (at the appropriate location)
	 * @param toInsert Item to be added
	 */
	void insert(T toInsert);
	
	/**
	 * Removes and returns the item at the front of the queue.
	 * @return Removed element
	 */
	T dequeue();
}