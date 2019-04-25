package dfs;

public class dfsRecursive {

	public static void inOrderLeft(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		inOrderLeft(root.left, sb);
		sb.append(root.val + " ");
		inOrderLeft(root.right, sb);

	}
	
	public static void inOrderRight(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		inOrderRight(root.right, sb);
		sb.append(root.val + " ");
		inOrderRight(root.left, sb);

	}

	public static void posOrder(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		posOrder(root.left, sb);
		posOrder(root.right, sb);
		sb.append(root.val + " ");
	}

	public static void preOrder(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val + " ");
		preOrder(root.left, sb);
		preOrder(root.right, sb);

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
		
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(0);
		TreeNode root4 = new TreeNode(1);
		TreeNode root5 = new TreeNode(-4);
		root1.right=root2;
		root1.left=root3;
		root3.right=root4;
		root3.left=root5;

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

		inOrderLeft(root, sb1);
		//inOrderRight(root,sb2);
		posOrder(root, sb2);
		preOrder(root, sb3);
		System.out.println("InOrder Left: ");
		System.out.println(sb1.toString());
//		System.out.println("InOrder Right: ");
//		System.out.println(sb2.toString());
		System.out.println("PosOrder: ");
		System.out.println(sb2.toString());
		System.out.println("PreOrder: ");
		System.out.println(sb3.toString());

	}
}
