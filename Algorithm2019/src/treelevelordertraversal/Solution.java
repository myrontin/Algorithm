package treelevelordertraversal;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void levelOrder(Node root) {
		System.out.println(levelOrder(root,""));
		
	}
	public static String levelOrder(Node root, String result){
		if(root!=null){
			 result = result +root.data+" ";
		}
	
		if(root.left!=null)
			result =  levelOrder(root.left,result);
		if(root.right!=null)
			result = levelOrder(root.right,result);
		return result;
	}
	
	public static void levelOrder1(Node root) {
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			sb.append(node.data+" ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		
		System.out.println(sb.toString());
		
		

	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.left=n2;
		n1.right=n3;
		n2.right=n4;
		n2.left = n5;
		
		
		
		levelOrder1(n1);	
		
	}
	
	
	
}
