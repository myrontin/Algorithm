package implementtrie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {

	private class Node {
		
		//Map to Node Array
		Map<Character, Node> node;
		Node[] map = new Node[26];
		boolean isEnd;
		public Node() {
			node = new HashMap<>();
			
		}
		
		public Node next(char c){
			if(node.containsKey(c)){
				return node.get(c);
			}else{
				return null;
			}
		}

	}

	Map<Character, Node> root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new HashMap<>();
		root.put(' ',new Node() );
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node leaf = root.get(' ');
		for (int i = 0; i < word.length(); i++) {
			if (!leaf.node.containsKey(word.charAt(i))) {
				Node newNode = new Node();
				leaf.node.put(word.charAt(i), newNode);
			}
			leaf = leaf.node.get(word.charAt(i));
		}
		
		leaf.isEnd=true;
		
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node leaf = root.get(' ');
		for (int i = 0; i < word.length(); i++) {
			if(leaf.node.containsKey(word.charAt(i))){
				leaf = leaf.node.get(word.charAt(i));
			}else{
				return false;
			}
				
		}
		return leaf.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Node leaf = root.get(' ');
		for (int i = 0; i < prefix.length(); i++) {
			if(leaf.node.containsKey(prefix.charAt(i))){
				leaf = leaf.node.get(prefix.charAt(i));
			}else{
				return false;
			}	
		}
		return true;
	}
	
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
		
		
	}

}
