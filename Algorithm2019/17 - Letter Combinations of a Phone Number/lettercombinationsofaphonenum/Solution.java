package lettercombinationsofaphonenum;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.length()==0) return result;
		String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			int n = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String s = result.poll();
				for (char c : map[n].toCharArray()) {
					result.add(s + c);
				}
			}
		}

		return result;
	}
}
