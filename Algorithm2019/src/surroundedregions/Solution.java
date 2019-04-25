package surroundedregions;

public class Solution {


	public static void solve(char[][] board) {

		if (board.length == 0 || board[0].length == 0 || board == null)
			return;
		int length = board.length;
		int width = board[0].length;
		boolean[][] isChecked = new boolean[length][width];
		for (int i = 1; i < length - 1; i++) {
			for (int j = 1; j < width - 1; j++) {
				if (isChecked[i][j] || board[i][j] == 'X')
					continue;
				if (isSurround(board, isChecked, i, j, i, j)) {
					transform(board, i, j);
				}
			}
		}

	}

	public static boolean isSurround(char[][] board, boolean[][] isChecked, int x, int y, int prevX, int prevY) {
		int length = board.length;
		int width = board[0].length;
		// boolean result = true;

		if (x == length - 1 || y == width - 1 || x == 0 || y == 0) {
			if (board[x][y] == 'O')
				return false;
			else
				return true;
		}
		
		if (isChecked[x][y]) {
			if (board[x][y] == board[prevX][prevY])
				return true;
			else
				return false;
		}
		if (board[x][y] == 'X') {
			return true;
		}
		isChecked[x][y] = true;
//		if (board[x][y] == 'O' && x != prevX && y != prevY)
//			return isSurround(board, isChecked, x, y, x, y);
		return isSurround(board, isChecked, x, y + 1, x, y) & isSurround(board, isChecked, x, y - 1, x, y)
				& isSurround(board, isChecked, x + 1, y, x, y) & isSurround(board, isChecked, x - 1, y, x, y);

	}

	public static void transform(char[][] board, int x, int y) {
		if (x <= 0 || y <= 0 || x >= board.length - 1 || y >= board[0].length - 1)
			return;
		if (board[x][y] == 'X')
			return;
		board[x][y] = 'X';
		transform(board, x + 1, y);
		transform(board, x - 1, y);
		transform(board, x, y - 1);
		transform(board, x, y + 1);
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		char[][] board1 = { { 'X', 'O', 'X' }, { 'X', 'O', 'X' }, { 'X', 'O', 'X' } };
		char[][] board2 = { { 'O', 'O', 'O', 'O', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O' } };
		char[][] board3 = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		char[][] board4 = { { 'O', 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O' }, { 'X', 'O', 'X', 'O', 'X' },
				{ 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		char[][] board5 = { 
				{ 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O' },
				{ 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O' },
				{ 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O' } };

		solve(board5);
		System.out.println(board5);
	}

}
