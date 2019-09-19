package simpleCalculator;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Calculator {

	public static final Set<Character> SET_OF_OPS = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

	public static int stringInputCalculator(String s) {

		if (s == null || s.isEmpty())
			throw new IllegalArgumentException("INPUT STRING IS NULL/EMPTY");
		s = s.replaceAll(" ", "");
		StringBuilder sb = new StringBuilder(s);
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '-') {
				deque.addLast(ch);
			}
			if (ch == '*' || ch == '/') {
				deque.addFirst(ch);
			}
			if (ch == '(') {
				int close = findIndexOfCloseParenthesis(i,s);
				
			}

		}

		while (!deque.isEmpty()) {
			char ch = deque.removeFirst();

			int indexOfOp = sb.indexOf(String.valueOf(ch));

			int indexOfNextOp = findIndexOfNextOperator(sb.toString(), indexOfOp);
			int indexOfPrevOp = sb.length()
					- findIndexOfNextOperator(sb.reverse().toString(), sb.length() - indexOfOp - 1);
			sb.reverse();
			String tmp = sb.substring(indexOfPrevOp, indexOfNextOp);

			int left = Integer.parseInt(sb.substring(indexOfPrevOp, indexOfOp));
			int right = Integer.parseInt(sb.substring(indexOfOp + 1, indexOfNextOp));

			sb.replace(indexOfPrevOp, indexOfNextOp, Integer.toString(calculator(left, right, ch)));

		}
		return Integer.parseInt(sb.toString().trim());

	}

	public static int findIndexOfNextOperator(String s, int n) {
		int result = s.length();
		for (int i = n + 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (SET_OF_OPS.contains(ch)) {
				if (ch == '-' && SET_OF_OPS.contains(s.charAt(i + 1)))
					return i + 1;
				return i;
			}
		}
		return result;
	}

	public static int calculator(int left, int right, char op) {

		switch (op) {
		case '+':
			return left + right;
		case '-':
			return left - right;
		case '*':
			return left * right;
		case '/':
			if (right == 0)
				throw new IllegalArgumentException("DENOMINATOR == 0");
			return left / right;
		default:
			throw new IllegalArgumentException("UNKNOWN OPERATOR");
		}

	}

	public static int findIndexOfCloseParenthesis(int open, String s) {
		Stack<Integer> stack = new Stack<>();

		if (s.charAt(open) != '(')
			return -1;
		for (int i = open; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			}

			if (ch == ')') {
				stack.pop();
				if (stack.isEmpty())
					return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		 String s = "10+7*12-90";
		 String s1 = "10+7*12-90*70-20+9283-3821";
		 System.out.println(stringInputCalculator(s1));
		//System.out.println(findIndexOfCloseParenthesis(3, "(()())()"));
	}

}
