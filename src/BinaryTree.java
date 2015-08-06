
public class BinaryTree {
	
	private static Node root;
	
	protected static class Node {
		Node left;
		Node right;
		String value;
		
		Node(String newValue) {
			left = null;
			right = null;
			value = newValue;
		}
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(String data) {
		root = insert(root, data);
	}
	
	private Node insert(Node node, String data) {
		if (node == null) {
			node = new Node(data);
		}
		else
		{
			if (data.compareTo(node.value) > 0) {
				node.right = insert(node.right, data);
			}
			else {
				node.left = insert(node.left, data);
			}
		}
		return node;
	}
	
	public int size() {
		return size(root);
	}
	
	private static int size(Node node) {
		if (node == null) {
			return 0;
		}
		else {
			return (size(node.left) + size(node.right) + 1);
		}
	}
	
	public Node getRoot() {
		return root;
	}

}
