package com.leetcode1209.LinkedListCycle;


//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head==null) return false;
		
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null) {
			fast = fast.next.next;
			if(fast == null) return false;
			slow = slow.next;
			if(fast==slow) 	return true;
		}
		return false;
	}
}




class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x;
		next = null;
	}
}