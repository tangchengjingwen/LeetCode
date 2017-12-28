package com.leetcode1227.MergekSortedLists;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author tangc
 *time :O(nlogk) space:O(n)
 */
public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return sort(lists, 0, lists.length - 1);
	}

	private ListNode sort(ListNode[] lists, int low, int high) {
		if (low >= high) return lists[low];
		int mid = low + (high - low)/2;
		ListNode l1 = sort(lists, low, mid);
		ListNode l2 = sort(lists, mid+1, high);
		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
	
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	
	
	
	//============================================================
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		for (ListNode list : lists) {
			if (list != null) {
				queue.add(list);
			}
		}
		while (!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if (cur.next != null) {
				queue.add(cur.next);
			}
		}
		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
