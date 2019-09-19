package longestpalindromicsubsequence;

public class Solution2019 {

	public static String longestPalindrome(String s) {
		int max = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {

			if (isPalindrome(s, i - max, i)) {
				result = s.substring(i - max, i + 1);
				max += 1;
			
			}
			if (isPalindrome(s, i - max - 1, i)) {
				result = s.substring(i - max -1, i+1);
				max += 2;	
	
			}
		}
		return result;
	}

	public static boolean isPalindrome(String s, int start, int end) {

		if (start < 0 || end > s.length())
			return false;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s ="aaaabaaa";
		String s1 ="caba";
		String s2 ="aaaaaaaaaaaaaaaaaaaaaaa";
		

		System.out.println(longestPalindrome(s2));
	}
}
