package com.leetcode1218.SortList;

//Sort a linked list in O(n log n) time using constant space complexity.

//归并排序的基本思想：找到链表的mid节点，然后递归前半部分和后半部分分别进行归并排序，每次排完序之后都要对排好序的链表进行归并：
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMidListNode(head);
		ListNode list2 = mid.next;
		mid.next = null;
		return mergeList(sortList(head), sortList(list2));
	}

	private ListNode mergeList(ListNode sortList, ListNode sortList2) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;

		while (sortList != null && sortList2 != null) {
			if (sortList.val < sortList2.val) {
				curr.next = sortList;
				sortList = sortList.next;
			} else {
				curr.next = sortList2;
				sortList2 = sortList2.next;
			}
			curr = curr.next;
		}
		curr.next = sortList != null ? sortList : sortList2;
		return dummyHead.next;
	}

	private ListNode getMidListNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}