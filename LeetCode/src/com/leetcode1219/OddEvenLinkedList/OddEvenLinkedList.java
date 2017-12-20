package com.leetcode1219.OddEvenLinkedList;

//		Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//		
//		You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//		
//		Example:
//		Given 1->2->3->4->5->NULL,
//		return 1->3->5->2->4->NULL.
public class OddEvenLinkedList {
	public ListNode oddEventList(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}