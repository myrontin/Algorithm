package basiccalculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static int calculate(String s) {

		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ')
				continue;
			if (sb.charAt(i) == '(') {
				int close = findCloseParenthesis(sb, i);
				int tmp = calculate(sb.substring(i + 1, close));
				sb = sb.replace(i, close + 1, String.valueOf(tmp));
			}
		}

		int sub = (sb.indexOf("-") == -1) ? Integer.MAX_VALUE : sb.indexOf("-");
		int add = (sb.indexOf("+") == -1) ? Integer.MAX_VALUE : sb.indexOf("+");
		if (sub == Integer.MAX_VALUE && add == Integer.MAX_VALUE) {
			add = sb.length();
		}
		String start = sb.substring(0, Math.min(sub, add)).toString().trim();

		if (start.isEmpty()) {
			// negative num fine the next one
			sub = (sb.indexOf("-", sub + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("-", sub + 1);
			add = (sb.indexOf("+", sub + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("+", sub + 1);
			if (sub == Integer.MAX_VALUE && add == Integer.MAX_VALUE) {
				add = sb.length();
				sub = sb.length();
			}
			start = sb.substring(0, Math.min(sub, add)).toString().trim();
		}

		int result = Integer.parseInt(start);

		for (int i = Math.min(sub, add); i < sb.length(); i++) {
			if (sb.charAt(i) == ' ')
				continue;
			if (sb.charAt(i) == '+' || sb.charAt(i) == '-') {
				char ops = sb.charAt(i);
				sub = (sb.indexOf("-", i + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("-", i + 1);
				add = (sb.indexOf("+", i + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("+", i + 1);
				// String left = sb.substring(start, i - 1);
				int next = Math.min(sub, add);
				if (next == Integer.MAX_VALUE) {
					next = sb.length();
				}

				String right = sb.substring(i + 1, next);
				if (right.isEmpty()) {
					// negative num fine the next one
					sub = (sb.indexOf("-", next + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("-", next + 1);
					add = (sb.indexOf("+", next + 1) == -1) ? Integer.MAX_VALUE : sb.indexOf("+", next + 1);
					// String left = sb.substring(start, i - 1);
					next = Math.min(sub, add);
					if (next == Integer.MAX_VALUE) {
						next = sb.length();
					}
					right = sb.substring(i + 1, next);
					i = next-1;
				}

				result = calculate(result, right, ops);
			}
		}
		return result;
	}

	public static int calculate(int l, String right, Character operator) {
		// int l = Integer.parseInt(left.trim());
		int r = Integer.parseInt(right.trim());

		switch (operator) {
		case ('+'):
			return l + r;
		case ('-'):
			return l - r;
		default:
			return -1;
		}

	}

	public static int findCloseParenthesis(StringBuilder sb, int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = n; i < sb.length(); i++) {
			if (sb.charAt(i) == '(') {
				stack.push(i);
			}
			if (sb.charAt(i) == ')') {
				stack.pop();
			}
			if (stack.isEmpty())
				return i;

		}
		return -1;

	}

	public static void main(String[] args) {
		String input1 = " 2-1 + 2 ";
		String input2 = "     1   ";
		String input3 = "(5-(1+(5)))";
		String input4 = "(1+(4+5+2)-3)+(6+8)";
		String input5 = "9-(6-8)";
		String input6 = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10";
		String input7 = "(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)";
		System.out.println(calculate(input1));
		System.out.println(calculate(input2));
		System.out.println(calculate(input3));
		System.out.println(calculate(input4));
		System.out.println(calculate(input5));
		System.out.println(calculate(input6));
		System.out.println(calculate(input7));
	}

}
