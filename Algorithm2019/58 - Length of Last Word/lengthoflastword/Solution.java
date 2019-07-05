package lengthoflastword;

public class Solution {
	public static int lengthOfLastWord(String s) {
		if (s.length() == 0)
			return 0;
		int i = s.length() - 1;
		int count = 0;
		while (i >= 0 && s.charAt(i) == ' ')
			i -= 1;
		while (i >= 0) {
			if (s.charAt(i) == ' ') {

				return count;

			}
			count++;
			i--;
		}

		return count;
	}
}
