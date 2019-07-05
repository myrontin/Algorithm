package rotatelist;

public class Solution {
	  public ListNode rotateRight(ListNode head, int k) {

			if (k == 0 || head == null)
			return head;
		int length = 1;
		ListNode first = head;
		while (head.next != null) {
			head = head.next;
			length++;
		}
		// connecting the end to first to form a circle
		head.next = first;
		// find the starting point
		int position = length - k % length;
		ListNode newHead = head;
		ListNode node = null;
		for (int i = 0; i < position + 1; i++) {
			if (i == position)
				node = newHead;
			newHead = newHead.next;
			if(node!=null)
			node.next=null;
		}

		// first.next = null;
		return newHead;
}
}
