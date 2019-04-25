package shortestpalindrome;

public class Solution {

	public static String shortestPalindrome(String s) {
		if (isPalindrome(s, 0, s.length() - 1))
			return s;
		int start = 0;
		int end = s.length() - 1;

		return s;
	}

	public static String longestPalindrome(String s) {
		int max = 0;
		String solution = "";
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i - max - 1, i)) {	//handle even number
				solution = s.substring(i - max - 1, i + 1);
				max += 2;
			}

			if (isPalindrome(s, i - max, i)) {	//handle odd number

				solution = s.substring(i - max, i + 1);
				max += 1;
			}
		}
		return solution;

	}

	public static boolean isPalindrome(String s, int start, int end) {
		if (start < 0)
			return false;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abdafsgregreadse"));
	}
}
