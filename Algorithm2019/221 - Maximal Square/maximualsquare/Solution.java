package maximualsquare;

public class Solution {
	public static int maximalSquare(char[][] matrix) {
		int max = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					max = Math.max(max, getAreaOfSquare(matrix, i, j));
			}

		}
		return max;
	}

	public static int getAreaOfSquare(char[][] matrix, int x, int y) {
		int length = matrix.length;
		int width = matrix[0].length;
		int i = x;
		int j = y;
		int count = 0;
		while (i < length && j < width && matrix[i][j] == '1') {

			for (int m = i; m >= x; m--) {
				if (matrix[m][j] == '0')
					return count * count;
			}
			for (int n = j; n >= y; n--) {
				if (matrix[i][n] == '0')
					return count * count;
			}
			count++;
			i++;
			j++;
		}
		return count * count;
	}

	public static void main(String[] args) {
		char[][] grid = {{'1','0','1','0','0'},{'1','0','1','1','0'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] grid1 = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
		char[][] grid2 = {};
		char[][] grid3 = {{'1'}};
		
		System.out.println(maximalSquare(grid));
		System.out.println(maximalSquare(grid1));
		System.out.println(maximalSquare(grid2));
		System.out.println(maximalSquare(grid3));
		
		
	}

}
