package binarytreerinordertraversal;

import java.util.ArrayList;
import java.util.List;

import dfs.TreeNode;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		return dfs(result, root);
	}

	public List<Integer> dfs(List<Integer> result, TreeNode root) {
		if (root == null)
			return result;
		dfs(result, root.left);
		result.add(root.val);
		dfs(result, root.right);

		return result;
	}

	public static List<Integer> morrisTraversal(TreeNode root) {
		TreeNode cur = root;
		List<Integer> result = new ArrayList<>();
		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == cur) {	//pre.right has been visited and set 
					pre.right = null;
					//read
					result.add(cur.val);
					cur = cur.right;
					
				} else {
					pre.right = cur;
					cur = cur.left;
				}
			} else {
				//no more left child
				result.add(cur.val);
				cur = cur.right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		
		root.right = node1;
		node1.left = node2;
		

		List<Integer> result = morrisTraversal(root);
		StringBuilder sb = new StringBuilder();
		for (int n : result) {
			sb.append(n + "->");
		}
		System.out.println(sb.toString());
	}

}
