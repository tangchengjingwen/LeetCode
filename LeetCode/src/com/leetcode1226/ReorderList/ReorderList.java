package com.leetcode1226.ReorderList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author tangc
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		ListNode tmp = null;
		ListNode slow = head, fast = head;
		ListNode l1 = head;
		
		while (fast != null && fast.next != null) {
			tmp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//把第一段的最后一个next指向null，即切断
		tmp.next = null;
		//slow此时就是第二段
		ListNode l2 = reverse(slow);
		merge(l1, l2);		
	}

	private void merge(ListNode l1, ListNode l2) {
		while(l1 != l2) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;
			l1.next = l2;
			if (n1 == null) break;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
		
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
