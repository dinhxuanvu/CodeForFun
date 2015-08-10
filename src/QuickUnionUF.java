
public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int n) {
		// Time complexity: N
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		// Time complexity: N
		
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		// Time complexity: N*N = N^2
		
		return root(p) == root(q);
	}
	
	public void union (int p, int q) {
		// Time complexity: N*N = N^2

		int x = root(p);
		int y = root(q);
		id[x] = y;
	}

}
