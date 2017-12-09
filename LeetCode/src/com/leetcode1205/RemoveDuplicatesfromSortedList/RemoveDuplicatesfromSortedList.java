package com.leetcode1205.RemoveDuplicatesfromSortedList;
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.


public class RemoveDuplicatesfromSortedList {
	//This is a simple problem that merely tests your ability to manipulate list node pointers.
	//Because the input list is sorted, we can determine if a node is a duplicate by comparing its value to the node after it in the list. 
	//If it is a duplicate, we change the next pointer of the current node so that it skips the next node and points directly to the one after the next node.
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
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