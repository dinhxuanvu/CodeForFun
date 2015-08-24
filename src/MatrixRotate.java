
public class MatrixRotate {
	
	/*
	 * Rotate a MxN matrix 90 degree to the right
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2},{3,4},{5,6}};
		int[][] matrix2 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(rotate(matrix, matrix.length, matrix[0].length));
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
		int layer = row/2;
		int[] temp;
		for (int i = 0; i < layer; i++) {
			temp = matrix[i];
			for (int j = i; j < (row-i); j++) {
				
			}
		}
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
