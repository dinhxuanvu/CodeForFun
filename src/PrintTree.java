import java.util.LinkedList;

public class PrintTree {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert("B");
		tree.insert("A");
		tree.insert("C");
		tree.insert("F");
		tree.insert("E");
		tree.insert("G");
		printTree(tree.getRoot());
		System.out.println(tree.size());
	}

	public static void printTree(BinaryTree.Node node) {
		if (node != null) {
			LinkedList<BinaryTree.Node> queue = new LinkedList<BinaryTree.Node>();
			queue.add(node);
			printSubTree(queue);
		}
	}

	public static void printSubTree(LinkedList<BinaryTree.Node> queue) {
		if (queue.isEmpty()) {
			return;
		} else {
			LinkedList<BinaryTree.Node> newQueue = new LinkedList<BinaryTree.Node>();
			BinaryTree.Node node;
			while (!queue.isEmpty()) {
				node = queue.remove();
				System.out.print(node.value);
				if ((node.left) != null) {
					newQueue.add(node.left);
				}
				if ((node.right) != null) {
					newQueue.add(node.right);
				}
			}
			System.out.print("\n");
			queue = newQueue; // Dereference the "old" queue so GC can reclaim it 
			printSubTree(queue);
		}
	}

}
