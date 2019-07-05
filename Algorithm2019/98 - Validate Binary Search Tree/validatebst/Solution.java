package validatebst;

import java.util.Stack;

import dfs.TreeNode;

public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.pop();
			// inorder
			if (prev != null && root.val < prev.val)
				return false;
			prev = root;
			root = root.right;
		}
		return true;
	}
}
