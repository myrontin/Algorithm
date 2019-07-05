package swapnodesinpairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if(head==null) return null;
		if (head.next != null)
			return swapPairs(head, head.next);
		return head;
	}

	public ListNode swapPairs(ListNode head, ListNode newHead) {
		if(newHead==null) return head;
		ListNode node = newHead.next;
		ListNode temp = head;
		
		newHead.next=head;
		temp.next = node;
		if(node!=null)
		head.next=swapPairs(node,node.next);

		return newHead;
	}
}
