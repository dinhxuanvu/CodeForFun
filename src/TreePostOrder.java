import java.util.ArrayList;

public class TreePostOrder {

	ArrayList<Integer> result;
	
	public ArrayList<Integer> preorderTraversal(Node root) {
		result = new ArrayList<Integer>();
		
		if (root != null) {
			postorder(root);
		}
		return result;
	}
	
	private void postorder(Node node) {
		if (node.left != null) {
			postorder(node.left);
		}
		
		if (node.right != null) {
			postorder(node.right);
		}
		
		result.add(node.value);
	}
}
