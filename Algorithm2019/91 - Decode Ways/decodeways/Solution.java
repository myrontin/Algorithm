package decodeways;

public class Solution {
	public static int numDecodings(String s) {
		if (s.length() == 0 || s.startsWith("0"))
			return 0;
		if (s.length() == 1)
			return 1;
		int[] dp = new int[s.length()];

		dp[0] = 1;

		if (s.charAt(1) == '0') {
			if (s.charAt(0) < '3')
				dp[1] = 1;
			else
				dp[1] = 0;
		} else {
			String substring = s.substring(0, 2);
			
			if (Integer.parseInt(substring)>26)
				dp[1] = 1;
			else
				dp[1] = 2;
		}

		for (int i = 2; i < dp.length; i++) {
			String substring = s.substring(i - 1, i + 1);
			int n = Integer.parseInt(substring);
			if (s.charAt(i) == '0') {
				if (n == 10 || n == 20) {
					dp[i] = dp[i - 2];
				} else
					return 0;
			} else {

				if (n > 10 && n <= 26) {
					dp[i] = dp[i - 1] + dp[i - 2];

				} else {
					dp[i] = dp[i - 1];
				}
			}
		}

		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("301"));
		System.out.println(numDecodings("1212"));
		System.out.println(numDecodings("27"));
		System.out.println(numDecodings("17"));
	}
}
