package reorderlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void reorderList(ListNode head) {
		if(head==null) return;
		Deque<ListNode> deque = new ArrayDeque<>();
		while (head.next != null) {
			deque.push(head);
			head = head.next;
		}
		deque.push(head);
		while (!deque.isEmpty()) {
			ListNode last = deque.pollLast();
			ListNode first = deque.pollFirst();
			last.next = first;
			if (first == null) {
				last.next = null;
			} else {
				first.next = deque.peekLast();
			}
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(5);

		head.next = node;
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		reorderList(head);

	}
}
