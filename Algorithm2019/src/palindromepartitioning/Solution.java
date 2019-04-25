package palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		return backTracking(result, new ArrayList<>(), s, 0);

	}

	public static List<List<String>> backTracking(List<List<String>> result, List<String> tmp, String s, int k) {
		if(k==s.length()){
			result.add(new ArrayList<>(tmp));
		}
		for (int i = k; i < s.length(); i++) {
			if (isPalindrome(s, k, i)) {
					tmp.add(s.substring(k, i+1));
					backTracking(result,tmp,s,i+1);
					tmp.remove(tmp.size()-1);
			}
		}

		return result;
	}

	public static boolean isPalindrome(String s, int start, int end) {
		if (start > end)
			return false;
		if (start == end)
			return true;

		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		List<List<String>> result = partition("efe");
		System.out.println(result);
	}

}
