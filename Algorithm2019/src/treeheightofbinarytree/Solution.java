package treeheightofbinarytree;

public class Solution {

	public static int height(Node root) {
		// Write your code here.
		return height(root, 0);
	}

	public static int height(Node root, int height) {
		if (root == null)
			return height-1;
		return Math.max(height(root.right, height + 1), height(root.left, height + 1));

	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		Node n6 = new Node(1);
		Node n7 = new Node(1);
		Node n8 = new Node(1);
		
		n1.left=n2;
		n1.right=n3;
		n2.right=n4;
		n2.left = n5;
		
		
		System.out.println(height(n1));
				
		
	}

}
