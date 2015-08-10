
public class BSTKeyInRange {
	/*
	 * Expect x <= y
	 */
	public static <TreeNode> void printKey(TreeNode root, int x, int y) {
		if (root == null) {
			return;
		}
		if (root.value > y) {
			printKey(root.left, x, y);
		}
		else if (root.value < x) {
			printKey(root.right, x, y);
		}
		else {
			printKey(root.left, x , y);
			System.out.println(root.value);
			printKey(root.right, x, y);
		}
	}

}
