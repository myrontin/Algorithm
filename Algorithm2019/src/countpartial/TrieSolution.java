package countpartial;

import java.util.HashMap;
import java.util.Map;

public class TrieSolution {

	class TrieNode {
		int size = 0;
		Map<Character, TrieNode> children = new HashMap<>();

		TrieNode(int size) {
			this.size = size;
		}

		public void putChildren(char ch) {
			if (!children.containsKey(ch)) {
				children.put(ch, new TrieNode(1));
			} else {
				TrieNode node = children.get(ch);
				node.size++;
			}
		}

		public TrieNode getChildren(char ch) {
			return children.get(ch);
		}

	}

	class Trie {
		TrieNode root = new TrieNode(0);

		Trie() {
		}

		public void add(String s) {
			TrieNode curr = root;
			for (char ch : s.toCharArray()) {
				curr.putChildren(ch);
				curr = curr.getChildren(ch);
			}
		}

		public int find(String s) {
			TrieNode curr = root;
			for (char ch : s.toCharArray()) {
				curr = curr.getChildren(ch);
				if (curr == null)
					return 0;
			}
			return curr.size;
		}

	}

	int[] contacts(String[][] queries) {
		/*
		 * Write your code here.
		 */
		int count=0;
		for(int i = 0;i<queries.length;i++){
			if(queries[i][0].equals("find")){
				count++;
			}
		}
		int[] result = new int[count];
		count=0;
		Trie trie = new Trie();
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].equals("add")) {
				trie.add(queries[i][1]);
			}
			if (queries[i][0].equals("find")) {
				
				//System.out.println(trie.find(queries[i][1]));
				result[count]=trie.find(queries[i][1]);
				count++;
			}
		}
		return result;
	}
	


	public static void main(String[] args) {
		TrieSolution solution = new TrieSolution();
		// String[][] queries
		// ={{"add","hack"},{"add","hackerrank"},{"find","hac"},{"find","hak"}};
		//String[][] queries = { { "add", "abcde" }, { "add", "abcee" }, { "find", "abc" }, { "find", "abce" } };
		
		String x ="aabbdc";
		System.out.println(x.substring(0,1));
	
//		for(int i :solution.contacts(queries)){
//			System.out.println(i);
//		}

	}

}
