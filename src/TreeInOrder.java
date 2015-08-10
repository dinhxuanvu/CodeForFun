import java.util.ArrayList;

class Node {
	int value;
	Node left;
	Node right;
	public Node(int n) {
		value = n;
	}
}

public class TreeInOrder {
	
	ArrayList<Integer> result;
	
	public ArrayList<Integer> inorderTraversal(Node root) {
		result = new ArrayList<Integer>();
		
		if (root != null) {
			inorder(root);
		}
		return result;
	}
	
	private void inorder(Node node) {
		if (node.left != null) {
			inorder(node.left);
		}
		
		result.add(node.value);
		
		if (node.right != null) {
			inorder(node.right);
		}
	}

}
