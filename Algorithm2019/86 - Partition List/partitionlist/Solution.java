package partitionlist;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static ListNode partition1(ListNode head, int x) {
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode node1 = head1;
		ListNode node2 = head2;
		while (head != null) {
			if (head.val < x) {
				if(head1==null){
					head1=head;
					node1=head;
				}else{
					node1.next =head;
					node1=node1.next;
				}
			} else {
				if(head2==null){
					head2=head;
					node2=head;
				}else{
					node2.next =head;
					node2=node2.next;
				}
			}
				head = head.next;
		}
		if(node1 ==null)
			return head2;
		if(node2 ==null)
			return head1;
		node1.next = head2;
		node2.next = null;
		return head1;
		
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null || x == 0 || head.next == null)
			return head;
		ListNode start = head;
		Queue<ListNode> queue = new LinkedList<>();
		while (start != null) {
			queue.add(start);
			start = start.next;
		}
		start = head; // point back to the first node
		ListNode end = new ListNode(99999);
		queue.add(end);
		ListNode newHead = null;
		ListNode next = null;
		int count = x;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			if (node != end) {
				if (count > 0 && node.val < x) {
					if (newHead == null) {
						// initial pick
						newHead = node;
						next = node;

					} else {
						next.next = node;
						next = next.next;
					}
					count--;
				} else if (count > 0 && node.val >= x) {
					queue.add(node);
				} else if (count == 0) {
					next.next = node;
					next = next.next;
				}
			} else {
				if (newHead == null)
					return head;

				while (!queue.isEmpty()) {
					ListNode node1 = queue.poll();
					next.next = node1;
					next = next.next;
				}
			}
		}
		next.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(2);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode head1 = new ListNode(1);
		ListNode node11 = new ListNode(1);
		head1.next = node11;

		StringBuilder sb = new StringBuilder();
		ListNode root = partition1(head1, 1);
		while (root != null) {
			sb.append(root.val + "->");
			root = root.next;
		}
		System.out.println(sb.toString());

	}

}
