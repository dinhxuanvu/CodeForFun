import java.util.ArrayList;

public class TreePreOrder {
	
	ArrayList<Integer> result;
	
	public ArrayList<Integer> preorderTraversal(Node root) {
		result = new ArrayList<Integer>();
		
		if (root != null) {
			preorder(root);
		}
		return result;
	}
	
	private void preorder(Node node) {
		
		result.add(node.value);
		
		if (node.left != null) {
			preorder(node.left);
		}
		
		if (node.right != null) {
			preorder(node.right);
		}
	}

}
