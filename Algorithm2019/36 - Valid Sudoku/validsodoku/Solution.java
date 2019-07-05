package validsodoku;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		Map<Character, Integer> vertical = new HashMap<>();
		Map<Character, Integer> horizontal = new HashMap<>();
		Map<Character, Integer> square1 = new HashMap<>();
		Map<Character, Integer> square2 = new HashMap<>();
		Map<Character, Integer> square3 = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			horizontal.clear();
			for (int j = 0; j < board[0].length; j++) {
				int k = 0;
				vertical.clear();
				if (j % 3 == 0) {
					square1.clear();
					square2.clear();
					square3.clear();
				}
				if (board[i][j] != '.') {
					if (horizontal.containsKey(board[i][j]))
						return false;
					horizontal.put(board[i][j], j);
				}
				while (k < board[0].length) {

					if (k >= 0 && k < 3) {
						if (board[k][j] != '.') {
							if (square1.containsKey(board[k][j])) {
								return false;
							}
							square1.put(board[k][j], j);
						}
					} else if (k >= 3 && k < 6) {
						if (board[k][j] != '.') {
							if (square2.containsKey(board[k][j])) {
								return false;
							}
							square2.put(board[k][j], j);
						}
					} else if (k >= 6 && k < 9) {
						if (board[k][j] != '.') {
							if (square3.containsKey(board[k][j])) {
								return false;
							}
							square3.put(board[k][j], j);
						}
					}

					if (board[k][j] != '.') {
						if (vertical.containsKey(board[k][j]))
							return false;
						vertical.put(board[k][j], j);

					}
					k++;
				}

			}
		}

		return true;
	}
}
