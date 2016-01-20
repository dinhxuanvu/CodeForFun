/**
 *
 * QueueNode.java
 * 
 * $Id: QueueNode.java,v 1.1 2013/09/25 05:13:18 vxd9797 Exp $
 *
 * $Log: QueueNode.java,v $
 * Revision 1.1  2013/09/25 05:13:18  vxd9797
 * Initial Revision
 *
 *
 */

/**
 * Class QueueNode handles the nodes for LinkedQueue.
 * 
 * @author vxd9797
 *
 */
public class QueueNode<T extends Prioritizable> {
	
	T t;
	QueueNode<T> newNode;
	
	/**
	 * Constructor accepts an object t.
	 * 
	 * @param T t - Object
	 */
	public QueueNode(T t) {
		this.t = t;
	}

	/**
	 * Get the data (an object) from QueueNode
	 */
	public T getObj() {
		return t;
	}
	
	/**
	 * Get the next node on the queue
	 * @return newNode - the next node
	 */
	public QueueNode<T> getNextNode() {
		return newNode;
	}
	
	/**
	 * Set the new node on the queue
	 * @param newNode - the new node
	 */
	public void setNextNode(QueueNode<T> newNode) {
		this.newNode = newNode;
	}
	
	/**
	 * Return the node's priority
	 * @return double value presenting node's priority
	 */
	public double getPriority() {
		return t.getPriority();
	}
}
