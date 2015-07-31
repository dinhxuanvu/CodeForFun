
public class InorderTraversalBST {
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		inorder(root, queue);
		return queue;
	}
	
	private void inorder(Node x, Queue<Key> queue) {
		if (x == null) return;
		inorder(x.left, queue);
		q.enqueue(x.key);
		inorder(x.right, queue);
	}
}
