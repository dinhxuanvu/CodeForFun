
public class Boggle {
	
	public static void main(String[] args) {
		String[] dict = new String[] {"GEEKS", "FOR", "QUIZ", "GO"};
		char[][] board = new char[][] {{'G','I','Z'},
										{'U','E','K'},
										{'Q','S','E'}};
		findWords(board,dict);
	}
	
	public static void findWords(char[][] board, String[] dict) {
		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; i < col; i++) {
				searchWord(board, dict, visited, "", i, j, row, col);
			}
		}
	}
	
	private static void searchWord(char[][] board, String[] dict, boolean[][] visited, 
			String str, int x, int y, int maxRow, int maxCol) {
		if (x < 0 || y < 0 || x >= maxRow || y >= maxCol)
			return;
		if (visited[x][y] == true)
			return;
		if (!isPrefix(str,dict))
			return;
		
		str = str + board[x][y];
		visited[x][y] = true;
		
		if (isWord(str,dict))
			System.out.println(str);
		
		for (int ii = -1; ii < 2; ii++) {
			for (int jj = -1; jj < 2; jj++) {
				searchWord(board, dict, visited, str, x+ii, y+jj, maxRow, maxCol);
			}
		}
		visited[x][y] = false;
	}
	
	private static boolean isWord(String str, String[] dict) {
		if (str == null || dict == null) {
			return false;
		}
		for (String s : dict) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isPrefix(String prefix, String[] dict) {
		if (prefix == null || dict == null) {
			return false;
		}
		
		if (prefix.isEmpty()) {
			return true;
		}
		
		for (String s : dict) {
			if (s.startsWith(prefix))
				return true;
		}
		return false;
	}
	
}
