import java.util.ArrayList;
import java.util.Arrays;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ZeroOutMatrix {
	
	public static void main(String[] args) {

		int[][] matrix = new int[5][10];
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		Pair p1 = new Pair(1,2);
		Pair p2 = new Pair(13,-4);
		
		pairs.add(p1);
		pairs.add(p2);
		
		matrix = zeroOut(matrix,pairs);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		
	}
	
	public static int[][] zeroOut(int[][] matrix, ArrayList<Pair> pairs) {
		if (pairs.isEmpty()) {
			return matrix;
		}
		if (matrix == null || matrix.length == 0) {
			return matrix;
		}
		
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		
		boolean[] row = new boolean[numRow];
		boolean[] col = new boolean[numCol];
		for (Pair p : pairs) {
			if (p.x >= 0 && p.x < numRow && row[p.x] == false) {
				row[p.x] = true;
			}
			if (p.y >= 0 && p.y < numCol && col[p.y] == false) {
				col[p.y] = true;
			}
		}

		int i;
		int j;
		for (i = 0; i < numRow; i++) {
			if (row[i] == true) {
				for (j = 0; j < numCol; j++) {
					matrix[i][j] = 1;
				}
			}
		}
		
		for (i = 0; i < numCol; i++) {
			if (col[i] == true) {
				for (j = 0; j < numRow; j++) {
					matrix[j][i] = 1;
				}
			}
		}
		return matrix;
	}

}
