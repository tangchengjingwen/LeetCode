package com.leetcode1222.LinkedListCycleII;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * @author tangc
 *
 */

// 2*(a+b) = a + b + c + b, a = c    time:O(n) space:O(1)
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				ListNode slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
