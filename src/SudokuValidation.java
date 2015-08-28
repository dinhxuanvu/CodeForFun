
public class SudokuValidation {

	public static void main(String[] args) {

		int[][] board = new int[][] { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		//System.out.println(isValid(board));
		System.out.println(isValid2(board));
	}

	public static boolean isValid(int[][] sudoku) {
		if (sudoku == null || sudoku.length == 0)
			return false;

		int size = sudoku.length;

		boolean[][] rows = new boolean[size][size];
		boolean[][] cols = new boolean[size][size];
		boolean[][] boxs = new boolean[size][size];

		int num;
		int index;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				num = sudoku[i][j];
				if (num < 1 || num > 9)
					return false;
				index = (i / 3) * 3 + (j / 3);
				if (rows[i][num - 1] || cols[j][num - 1] || boxs[index][num - 1])
					return false;
				else {
					rows[i][num - 1] = true;
					cols[j][num - 1] = true;
					boxs[index][num - 1] = true;
				}
			}
		}
		return true;
	}

	public static boolean isValid2(int[][] sudoku) {
		if (sudoku == null || sudoku.length == 0)
			return false;

		int flag = 0;
		int bit;
		int num;
		// Check row
		for (int i = 0; i < sudoku.length; i++) {
			for (int k = 0; k < sudoku.length; k++) {
				num = sudoku[i][k];
				if (num < 1 || num > 9)
					return false;
				else {
					bit = 1 << num;
					if ((flag & bit) != 0)
						return false;
					flag |= bit;
				}
			}
			flag = 0;
		}

		// Check column
		for (int i = 0; i < sudoku.length; i++) {
			for (int k = 0; k < sudoku.length; k++) {
				num = sudoku[k][i];
				bit = 1 << num;
				if ((flag & bit) != 0)
					return false;
				flag |= bit;
			}
			flag = 0;
		}
		
		
		// Check box
		for (int row = 0; row < sudoku.length; row += 3) {
			for (int col = 0; col < sudoku.length; col += 3) {
				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						num = sudoku[i][j];
						bit = 1 << num;
						if ((flag & bit) != 0)
							return false;
						flag |= bit;
					}
					flag = 0;
				}
			}
		}
		return true;

	}

}
