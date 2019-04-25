package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSIterative {

	public void inorderDFSIter(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;

			} else {
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;

			}
		}

	}

	public void posorderDFSIter(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> deque = new ArrayDeque<>();
		while(!deque.isEmpty()||root!=null){
			if(root!=null){
				deque.push(root);
				System.out.println(root.val);
				root=root.right;
			}else{
				root =deque.pop();
				root=root.left;
				
			}
		}
		
		
	}

	public void preorderDFSIter(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				System.out.println(root.val);
				root = root.left;

			} else {
				root = stack.pop();
				root = root.right;

			}
		}
	}

	public static void main(String[] args) {
		DFSIterative dfs = new DFSIterative();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;

		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(0);
		TreeNode root4 = new TreeNode(1);
		TreeNode root5 = new TreeNode(-4);
		root1.right = root2;
		root1.left = root3;
		root3.right = root4;
		root3.left = root5;

		// StringBuilder sb1 = new StringBuilder();
		// StringBuilder sb2 = new StringBuilder();
		// StringBuilder sb3 = new StringBuilder();
		// System.out.println("InOrder Left: ");
		// dfs.inorderDFSIter(root);
		
		dfs.posorderDFSIter(root);
		// inOrderRight(root,sb2);
		// posOrder(root, sb2);
		// preOrder(root, sb3);

		// System.out.println(sb1.toString());
		// System.out.println("InOrder Right: ");
		// System.out.println(sb2.toString());
		// System.out.println("PosOrder: ");
		// System.out.println(sb2.toString());
		// System.out.println("PreOrder: ");
		// System.out.println(sb3.toString());

	}

}
