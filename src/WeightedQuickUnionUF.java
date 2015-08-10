
public class WeightedQuickUnionUF {
	private int[] id;
	private int[] size;
	
	public WeightedQuickUnionUF(int n) {
		// Time complexity: N
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i) {
		// Time complexity: N
		
		while (i != id[i]) {
			// Path compression
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		// Time complexity: N*N = N^2
		
		return root(p) == root(q);
	}
	
	public void union (int p, int q) {
		// Time complexity: lgN

		int x = root(p);
		int y = root(q);
		if (x == y)
			return;
		if (size[x] < size[y]) {
			id[x] = y;
			size[y] += size[x];
		}
		else {
			id[y] = x;
			size[x] += size[y];
		}
	}
}
