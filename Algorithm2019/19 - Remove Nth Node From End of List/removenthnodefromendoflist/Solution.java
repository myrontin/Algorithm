package removenthnodefromendoflist;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	int found = 0;
	ListNode start = head;
	ListNode prev = head;
	int j = 0;
	while (found == 0) {

		ListNode node = head.next;
		j++;
		prev=node;
		for (int i = 0; i < n; i++) {
			
			if (node != null) {
				node = node.next;
				j++;
			}
		}
		if (node == null) {
			found = 1;
		}
		if (found == 1) {
			if(head.next!=null)
			head.next = head.next.next;
		}
		head = head.next;
		
	}
	if(j<=n) return prev;
	return start;


}
}
