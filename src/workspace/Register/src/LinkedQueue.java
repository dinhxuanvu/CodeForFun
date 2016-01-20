/**
 *
 * LinkedQueue.java
 * 
 * $Id: LinkedQueue.java,v 1.1 2013/09/25 05:13:19 vxd9797 Exp $
 *
 * $Log: LinkedQueue.java,v $
 * Revision 1.1  2013/09/25 05:13:19  vxd9797
 * Initial Revision
 *
 *
 */

/**
 * Class LinkedQueue presents the data structure of collection of queues 
 * which are linked as a series of nodes.
 * 
 * @author vxd9797
 *
 */
public class LinkedQueue<T extends  Prioritizable> implements PriorityQueue<T> {
	
	private QueueNode<T> newQueueNode;

	/**
	 * Insert a new object t into the LinkedQueue by comparing with current nodes
	 * there are any.
	 * 
	 * @param T newT - Object
	 */
	public void insert(T newT) {
		QueueNode<T> newNode = new QueueNode<T>(newT);
		QueueNode<T> currentNode;
		
		// Empty queue
		if (this.isEmpty()) {
			newQueueNode = newNode;
		}
		// Queue has only one node
		else if (newQueueNode.getNextNode() == null) {
			// Check the node's priority
			if (newQueueNode.getPriority() <=  newNode.getPriority()) {
				newNode.setNextNode(newQueueNode);
				newQueueNode = newNode;
			}
			else
				newQueueNode.setNextNode(newNode);
		}
		else {
			currentNode = newQueueNode;
			while (currentNode.getNextNode() != null) {
				// Compare node's priority for each node in the queue
				if (currentNode.getPriority() <= newNode.getPriority() 
						&& currentNode.getNextNode().getPriority() >= newNode.getPriority()) {
					newNode.setNextNode(currentNode.getNextNode());
					break;
				}
			}
			currentNode.setNextNode(newNode);
		}
	}

	@Override
	/**
	 * Check if the node is empty
	 * @return boolean true or false
	 */
	public boolean isEmpty() {
		
		if (newQueueNode == null)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * Remove (dequeue) a node out of the linked queue
	 */
	public T dequeue() {
		T objT;
		if (this.isEmpty()) {
			return null;
		}
		else {
			objT = newQueueNode.getObj();
			newQueueNode = newQueueNode.getNextNode();
			return objT;
		}
	}

}
