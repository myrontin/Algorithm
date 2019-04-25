package removeduplicateslist;

import javax.xml.soap.Node;

public class Solution {
	static ListNode root;

	public static ListNode deleteDuplicates1(ListNode head) {
		ListNode entry = head;
		ListNode prev = head;
		while (head != null) {
			ListNode next = head.next;
			if (next != null && head.val == next.val) {

				while (next != null && next.val == head.val) {
					next = next.next;
				}

				if (prev.val == head.val) {
					prev = next;
					entry = prev;
					head = next;
				} else {
					prev.next = next;
					head = next;
				}

			} else {
				head = head.next;
			}
			if (prev != null && prev.next != null && prev.next.next != null && prev.next.val != prev.next.next.val) {
				prev = next;
			}

		}

		return entry;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		root = head;
		deleteDuplicatesRecursive1(head, null);
		return root;

	}

	public static ListNode deleteDuplicatesRecursive(ListNode head, ListNode prev) {
		if (head == null)
			return head;
		ListNode next = head.next;
		if (next == null)
			return head;

		if (head.val == next.val) {
			prev.next = deleteDuplicatesRecursive(next, prev);
		} else {
			return next;
		}
		deleteDuplicatesRecursive(next, prev);
		return next;
	}

	public static ListNode deleteDuplicatesRecursive1(ListNode head, ListNode prev) {
		if (head == null)
			return head;
		ListNode next = head.next;
		if (next == null)
			return head;
		if (head.val == next.val) {
			prev.next = deleteDuplicatesRecursive(next, prev);
		} else {
			deleteDuplicatesRecursive(next, head);
		}
		return next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode head1 = new ListNode(1);
		ListNode node11 = new ListNode(1);

		head1.next = node11;

		StringBuilder sb1 = new StringBuilder();
		ListNode node = deleteDuplicates1(head1);

		while (node != null) {
			sb1.append(node.val + "->");
			node = node.next;
		}
		System.out.println(sb1.toString());

	}
}
