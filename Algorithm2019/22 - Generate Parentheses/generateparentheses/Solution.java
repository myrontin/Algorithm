package generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();

		generateParenthesis(result, new String(), 0, 0, n);

		return result;
	}

	public void generateParenthesis(List<String> result, String temp, int open, int close, int max) {
		if (temp.length() == max * 2)
			result.add(new String(temp));

		if (open < max) {

			generateParenthesis(result, temp + "(", open + 1, close, max);
		}
		if (close < open) {
			generateParenthesis(result, temp + ")", open, close + 1, max);
		}

	}
}
