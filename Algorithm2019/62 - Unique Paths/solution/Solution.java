package solution;

public class Solution {
	public static int uniquePaths(int m, int n) {
		if(m==0 ||n==0) return 0;
		
		int[][] dp = new int[m][n];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=1;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][0]=1;
		}
		
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				dp[i][j] =dp[i][j-1]+dp[i-1][j];
			}
		}

		return dp[m - 1][n - 1];

	}
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
		
		
	}
	
}
