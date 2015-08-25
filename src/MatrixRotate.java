
public class MatrixRotate {
	
	/*
	 * Rotate a MxN matrix 90 degree to the right
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2},{3,4},{5,6}};
		int[][] matrix2 = new int[][] {{1,2,3,4},{5,6,7,8},{2,4,6,8},{1,3,5,7}};
		printMatrix(rotate(matrix, matrix.length, matrix[0].length));
		System.out.println();
		printMatrix(rotateSquare(matrix2, matrix2.length));
	}
	
	public static int[][] rotate(int[][] matrix, int row, int col) {
		if (matrix == null || matrix.length == 0) {
			return matrix;
		}
		if (row != col) {
			int[][] newMatrix = new int[col][row];
			for (int i = 0; i < col; i++) {
				for (int j = (row-1); j >= 0; j--) {
					newMatrix[i][row-j-1] = matrix[j][i];
				}
			}
			return newMatrix;
		}
		else
			return rotate2(matrix, row);
	}
	
	private static int[][] rotate2(int[][] matrix, int row) {
		for (int layer = 0; layer < row/2; layer++) {
			int first = layer;
			int last = row - layer - 1;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// Save the top cell
				int top = matrix[first][i];
				// Copy left to top
				matrix[first][i] = matrix[last-offset][first];
				// Copy bottom to left
				matrix[last-offset][first] = matrix[last][last-offset];
				// copy right to bottom
				matrix[last][last-offset] = matrix[i][last];
				// Copy top to right
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
	
	public static int[][] rotateSquare(int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; layer++) {
			int last = n - layer - 1;
			for (int i = layer; i < last; i++) {
				int offset = i - layer;
				// Save the top
				int top = matrix[layer][i];
				// Copy left to the top
				matrix[layer][i] = matrix[last-offset][layer];
				// Copy bottom to the left
				matrix[last-offset][layer] = matrix[last][last-offset];
				// Copy from right to bottom
				matrix[last][last-offset] = matrix[i][last];
				// Copy from top to right
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
	public static void printMatrix(int[][] matrix) {
		for (int[] items : matrix) {
			for (int item : items) {
				System.out.print(item + " ");
			}
			System.out.print("\n");
		}
	}

}
