package com.leetcode1211.ReverseLinkedList;


//Reverse a singly linked list.
//
//click to show more hints.
//
//Hint:
//A linked list can be reversed either iteratively or recursively. Could you implement both?
//

public class ReverseLinkedList {
	//iterative
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
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