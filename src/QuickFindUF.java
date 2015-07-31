public class QuickFindUF {

	private int[] id;

	public QuickFindUF(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		// Time complexity: N*N = N^2
		
		int x = id[p];
		int y = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] != x) {
				id[i] = y;
			}
		}
	}

}
