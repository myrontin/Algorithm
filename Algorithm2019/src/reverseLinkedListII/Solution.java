package reverseLinkedListII;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import addtwonumbers.ListNode;

public class Solution {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode head1 = null;
		ListNode node1 = head;
		ListNode end = head;
		Stack<ListNode> stack = new Stack<>();
		Queue<ListNode> queue = new LinkedList<>();
		int count = n - m;
		while (m - 2 >= 0 && node1 != null) {
			if (head1 == null) {
				head1 = node1;
				end = node1;
				node1 = node1.next;
			} else {
				end = node1;
				node1 = node1.next;
			}
			m--;
		}

		while (node1 != null && count >= 0) {
			stack.add(node1);
			node1 = node1.next;
			count--;
		}

		while (node1 != null) {
			queue.add(node1);
			node1 = node1.next;
		}
		if(head1 ==null){
			head1=stack.peek();
		}
		while (!stack.isEmpty()) {
			end.next = stack.pop();
			end = end.next;

		}
		while (!queue.isEmpty()) {
			end.next = queue.poll();
			end = end.next;
		}

		end.next = null;

		return head1;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		StringBuilder sb = new StringBuilder();
		ListNode root = reverseBetween(head, 1, 4);
		while (root != null) {
			sb.append(root.val + "->");
			root = root.next;
		}
		System.out.println(sb.toString());

	}

}
