
public class SolveSudoku {

	public static void main(String[] args) {

	}

	public static boolean solve(int[][] sudoku, int row, int col) {
		if (col == 9) {
			col = 0;
			if (row++ == 9) {
				return true;
			}
		}
		
		if (sudoku[row][col] == 0)
			solve(sudoku,row,col+1);
		
		for (int i = 1; i <= 9; i++) {
			if (check(sudoku,i,row,col)) {
				sudoku[row][col] = i;
				solve(sudoku,row,col+1);
			}
		}
	}

	private static boolean check(int[][] sudoku, int value, int row, int col) {
		// Check row
		int i;
		for (i = 0; i < 9; ++i) {
			if (value == sudoku[row][i]) {
				return false;
			}
		}

		// Check column
		for (i = 0; i < 9; ++i) {
			if (value == sudoku[i][col]) {
				return false;
			}
		}
		
		// Check box
		int rowOffset = (row/3)*3;
		int colOffset = (col/3)*3;
		
		for (i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (value == sudoku[rowOffset+i][colOffset+j])
					return false;
			}
		}
		return true;
	}

	public static void printMatrix(int[][] matrix) {
		if (matrix == null)
			return;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
	}
}
