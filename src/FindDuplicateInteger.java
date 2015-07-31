import java.util.HashSet;

/*
 * Find all duplicates from array of integer from 1
 * to 1.000.000
 */
public class FindDuplicateInteger {
	
	public static void main(String[] args) {
		int[] list = new int[] {1, 3, 2, 5, 4, 2, 3, 1};
		findDuplicate(list);
		System.out.println();
		findDuplicate2(list);
	}
	/*
	 * Solution 1: Use HashSet to find duplicate
	 * Notes: Linear time search (O(n)) but O(n) in space.
	 * For Java: Suffer from autoboxing since there is no
	 * primitive type collection.
	 */
	public static void findDuplicate(int[] n) {
		if (n.length > 0) {
			HashSet<Integer> list = new HashSet<Integer>();
			for (int i = 0; i < n.length; i++) {
				if (list.contains(n[i])) {
					System.out.print(n[i] + " ");
					// If only find the first duplicate
					// then break here.
				}
				else
					list.add(n[i]);
			}
		}
		
	}
	
	/*
	 * Use an array of boolean to keep track of duplication
	 * Notes: Still linear time O(n) and O(n) for space but
	 * smaller as it's only array of boolean instead of
	 * list of Integer object.
	 * Also, this solution avoids autoboxing.
	 */
	public static void findDuplicate2(int[] n) {
		if (n.length > 0) {
			boolean[] list = new boolean[n.length + 1];
			
			for (int i = 0; i < n.length; i++) {
				if (list[n[i]]) {
					System.out.print(n[i] + " ");
					// If only find the first duplicate
					// then break here.
				}
				else
					list[n[i]] = true;
			}
		}
	}

}
