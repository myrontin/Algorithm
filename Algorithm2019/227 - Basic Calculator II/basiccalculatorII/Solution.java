package basiccalculatorII;

import java.util.Stack;

public class Solution {
	public int calculate(String s) {

	      Stack<Integer> stack = new Stack<>();
			char prev = '+';
			int num = 0;
			s += '+';
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c== ' ') continue;
				if (Character.isDigit(c)) {
					num = num * 10 + c - '0';
					continue;
				} else {
					switch (prev) {
					case ('+'):
						stack.push(num);
						break;
					case ('-'):
						stack.push(0 - num);
						break;
					case ('*'):
						stack.push(stack.pop() * num);
						break;
					case ('/'):
						stack.push(stack.pop() / num);
						break;
					}
					num = 0;
					prev = c;
				}
		
			}
				int result = 0;
			int stackSize = stack.size();
			for(int i = 0;i<stackSize;i++) {
				result += stack.pop();
			}
			return result;
	}

	public static void main(String[] args) {
		for (String s : "1+2*3/4".split("\\+|\\-|\\*|\\/")) {
			System.out.println(s);
		}
	}

}
