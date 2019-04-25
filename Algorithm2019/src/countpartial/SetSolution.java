package countpartial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetSolution {

	static int[] contacts(String[][] queries) {
		/*
		 * Write your code here.
		 */
		int find = 0;
		Set<String> contact = new HashSet<>();
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].equals("find")) {
				find++;
			}
		}
		int[] result = new int[find];
		find = 0;
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].equals("add")) {
				// do add
				addName(contact, queries[i][1]);
			}
			if (queries[i][0].equals("find")) {
				// do find
				result[find] = findPartial(contact, queries[i][1]);
				find++;
			}

		}

		return result;

	}

	public static Set<String> addName(Set<String> contact, String s) {
		contact.add(s);
		return contact;
	}

	public static int findPartial(Set<String> contact, String s) {
		int result = 0;

		for (String name : contact) {
			if (name.contains(s)) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[][] queries = { { "1", "" }, { "3", "4" } };
		contacts(queries);

	}

}
