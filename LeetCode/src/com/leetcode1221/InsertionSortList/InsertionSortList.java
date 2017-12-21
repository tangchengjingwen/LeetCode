package com.leetcode1221.InsertionSortList;

/**
 * Sort a linked list using insertion sort.
 * @author tangc
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode tmp = null, prev = null;
		while (cur!=null && cur.next!=null) {
			if (cur.val <= cur.next.val) {
				cur = cur.next;
			} else {
				tmp = cur.next;
				cur.next = tmp.next;
				prev = dummy;
				while (prev.next.val <= tmp.val) {
					prev = prev.next;
				}
				tmp.next = prev.next;
				prev.next = tmp;
			}
		}
		return dummy.next;
	}
}

class ListNode {
	int val; 
	ListNode next;
	ListNode (int x) {
		val = x;
	}
}
