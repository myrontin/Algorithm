package minimumpathsum;

public class Solution {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(i==0&&j==0) continue;
				if (i == 0 && j < col) {
					dp[i][j] = dp[i][j-1] + grid[i][j]; // current + left 
				}
				else if(j==0&&i<row){
					dp[i][j]= dp[i-1][j]+grid[i][j]; //current + top
				}else{
					dp[i][j]= Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]); // compare min val of top and left
				}
				
			}
		}
		return dp[row-1][col-1];
	}
}
