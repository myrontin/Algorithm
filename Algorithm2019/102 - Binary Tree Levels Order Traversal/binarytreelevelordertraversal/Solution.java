package binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dfs.TreeNode;

public class Solution {

	public static List<List<Integer>> bfs(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty() || !queue2.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue2.add(node.left);
				}

				if (node.right != null) {
					queue2.add(node.right);
				}
			}
			if (queue.isEmpty()) {
				result.add(level);
				queue.addAll(queue2);
				queue2  = new LinkedList<>();
				level = new ArrayList<>();
			}

		}
		return result;
	}

	public static void main(String[] args) {
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

		List<List<Integer>> result = bfs(root);
		
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(0);
		TreeNode root4 = new TreeNode(1);
		TreeNode root5 = new TreeNode(-4);

		root1.right = root2;
		root1.left = root3;
		root3.right = root4;
		root3.left = root5;

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

	}

}
