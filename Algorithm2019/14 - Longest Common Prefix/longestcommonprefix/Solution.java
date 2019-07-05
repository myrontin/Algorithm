package longestcommonprefix;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		String result = strs[0];
		
		
		for (String s : strs) {
			int i = 0;
			if(result.isEmpty()) return result;
			while (i<result.length()&&i<s.length()&&s.charAt(i) == result.charAt(i)) {
				i++;

			}
			if(result.length()>i)
			result = result.substring(0, i);
		}

		return result;

	}
}
