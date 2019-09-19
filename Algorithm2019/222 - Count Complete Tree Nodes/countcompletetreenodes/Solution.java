package countcompletetreenodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static int countNodes(TreeNode root) {
		if(root==null) return 0;
		int leftHeight = findLeftHeight(root)-1;
		int rightHeight = findRightHeight(root)-1;
		if (leftHeight == rightHeight) {
			return ((2 << (leftHeight)) -1);}
		else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	public static int findLeftHeight(TreeNode root) {
		if (root == null)
			return 0 ;
		return findLeftHeight(root.left)+1;

	}

	public static int findRightHeight(TreeNode root) {
		if (root == null)
			return 0;
		return findRightHeight(root.right)+1;

	}

	public static int DFSSolution(TreeNode root, int height, int count) {
		if (root == null) {
			return count;
		}
		if (root.right != null) {
			count += 2;
			return DFSSolution(root.right, height++, count);
		} else {
			count += 1;
			return DFSSolution(root.right, height++, count);
		}

	}

	public static int BFSSolution(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();

		int count = 1;

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
				count++;
			}

			if (node.right != null) {
				queue.add(node.right);
				count++;
			}

		}

		return count;

	}

	public static List<Integer> dfs(TreeNode root, List<Integer> result) {
		if (root == null)
			return result;
		dfs(root.right, result);
		result.add(root.val);
		dfs(root.left, result);

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;

		System.out.println(findRightHeight(root));
		System.out.println(findLeftHeight(root));
		System.out.println(countNodes(root));
	}
}
