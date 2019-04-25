package longestpalindromicsubsequence;

public class Solution {

	public static int longestPalindromeSubseqRecursion(String s) {
		int n = s.length();
		return recursion(s, n - 1, new int[n][n]);

	}

	public static int recursion(String s, int i, int[][] memory) {
		if (memory[0][memory.length - 1] != 0)
			return memory[0][memory.length - 1];

		for (int j = i; j < memory.length; j++) {
			if (i == j) {
				memory[i][i] = 1;
				continue;
			}

			if (s.charAt(i) == s.charAt(j)) {
				memory[i][j] = memory[i + 1][j - 1] + 2;
			} else {
				memory[i][j] = Math.max(memory[i + 1][j], memory[i][j - 1]);
			}
		}
		return recursion(s, i - 1, memory);

	}

	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {

				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}

			}
		}
		return dp[0][n - 1];
	}

	public static String longestPalindrome(String s) {
		if (s.isEmpty())
			return s;
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				end = i + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			int k = 0;
			for (int j = i + 1; j < n; j++) {
				// print(dp);
				if (dp[k + 1][j - 1] && s.charAt(k) == s.charAt(j)) {
					start = k;
					end = j;
					dp[k][j] = true;
				}
				k++;
			}
		}
		return s.substring(start, end + 1);
	}

	public static boolean isPalindrome(String s, int start, int end) {
		if (start < 0)
			return false;
		if (start == end)
			return true;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void print(boolean dp[][]) {
		System.out.println("##############################");
		for (int i = 0; i < dp.length; i++) {
			System.out.println();
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print("" + dp[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("##############################");

	}

	public static void print(int dp[][]) {
		System.out.println("##############################");
		for (int i = 0; i < dp.length; i++) {
			System.out.println();
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print("" + dp[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("##############################");

	}

	public static void main(String[] args) {
		// System.out.println(longestPalindromeSubseq("abcabcabcabc"));
		System.out.println(longestPalindromeSubseqRecursion("bbbab"));
	}

}
