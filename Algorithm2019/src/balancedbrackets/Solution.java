package balancedbrackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static String isBalanced(String s) {
		String yes = "YES";
		String no = "NO";
		if (s.isEmpty())
			return no;
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Stack<Character> stack = new Stack<>();
		if (s.length() % 2 != 0)
			return no;
		for (char ch: s.toCharArray()) {
			if (map.containsKey(ch)) {
				// close
				if (stack.isEmpty())
					return no;
				Character c = stack.pop();
				if (map.get(ch) != c) {
					return no;
				}

			}
			if(map.containsValue(ch)){
				//open
				stack.add(ch);
				continue;
			}
		}
		
		if(!stack.isEmpty())
			return no;
		
		return yes;		
	}
	
	
	public static void main(String[] args){
		String test ="{{}(";
		System.out.println(isBalanced(test));
		
		
		
		
	}
}
