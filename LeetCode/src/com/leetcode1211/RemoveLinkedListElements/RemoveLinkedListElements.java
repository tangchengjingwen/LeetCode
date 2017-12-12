package com.leetcode1211.RemoveLinkedListElements;



//
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5


//设置两个指针，一快一慢
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = head;
		while (q!=null) {
			if(q.val == val) {
				p.next = q.next;
			} else {
				p = p.next;
			}
			q = q.next;
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
