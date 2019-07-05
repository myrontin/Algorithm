package multiplystring;

public class Solution {
	public String multiply(String num1, String num2) {
		char[] char1 = num1.toCharArray();
		char[] char2 = num2.toCharArray();
		int x = num1.length();
		int y = num2.length();
		int[] result = new int[x + y];
		if ((x == 1 || y == 1) && (char1[0] == '0' || char2[0] == '0'))
			return "0";
		for (int i = x - 1; i > -1; i--) {
			for (int j = y - 1; j > -1; j--) {
				int pos1 = i + j + 1;
				int pos2 = pos1 - 1;
				int mult = (int) ((char1[i] - '0') * (char2[j] - '0'));
				result[pos2] += mult / 10;
				result[pos1] += mult % 10;
			}
		}
		for (int k = result.length - 1; k > -1; k--) {
			if (result[k] > 9) {
				result[k - 1] += result[k] / 10;
				result[k] %= 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (i == 0 && result[i] == 0)
				continue;

			sb.append(result[i]);
		}

		return sb.toString();
	}
}
