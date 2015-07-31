
public class InOrderTraversal {
	
	class TraversalRank {
		int counter = 0;
	}
	
	public int inOrderTraversal(TreeNode node, int n, TraversalRank rank) {
		if (node == null)
			return 0;
		int x = inOrderTraversal(node.left, n, rank);
		rank.counter++;
		if (n == rank.counter)
			return node.data;
		int y = inOrderTraversal(node.right, n, rank);
		int c = (x==0) ? y : x;
	}

}
