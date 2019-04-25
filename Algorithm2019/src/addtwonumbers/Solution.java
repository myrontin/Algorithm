package addtwonumbers;

public class Solution {
	// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// int val1 = 0;
	// int val2 = 0;
	// int sum = 0;
	// if (l1 != null)
	// val1 = l1.val;
	// if (l2 != null)
	// val2 = l2.val;
	// sum = val1 + val2;
	// int carry = sum / 10;
	// ListNode result = new ListNode(sum % 10);
	//
	// while (l1.next != null && l2.next != null) {
	//
	// l1 = l1.next;
	// l2 = l2.next;
	// if (l1 == null)
	// val1 = 0;
	// else
	// val1 = l1.val;
	// if (l2 == null)
	// val2 = 0;
	// else
	// val2 = l2.val;
	// sum = val1+val2+carry;
	// carry =sum/10;
	// ListNode tmp = new ListNode(sum%10);
	//
	//
	//
	//
	//
	// }
	//
	// return result;
	//
	// }

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if(l1==null)
			l1 = new ListNode(0);
		if(l2==null)
			l2 = new ListNode(0);
		int val1 =l1.val;
		int val2=l2.val;
		int sum;
		if (l1 != null)
			val1 = l1.val;
		if (l2 != null)
			val2 = l2.val;
		sum = val1 + val2 + carry;
		carry = sum/10;
		ListNode result = new ListNode(sum % 10);
		
		if ((l1.next != null || l2.next != null )||carry!=0) {
					result.next = addTwoNumbers(l1.next, l2.next, carry);
		}
		return result;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
//		ListNode l1 = new ListNode(5);
//		ListNode l4 = new ListNode(5);
		ListNode result = addTwoNumbers(l1, l4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
