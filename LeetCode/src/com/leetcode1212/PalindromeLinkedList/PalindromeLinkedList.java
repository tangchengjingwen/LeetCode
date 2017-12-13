package com.leetcode1212.PalindromeLinkedList;

import java.util.Stack;

//Given a singly linked list, determine if it is a palindrome.

//使用快慢指针
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		// 判断链表如果为奇数，则跳过中间元素
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (stack.pop() != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;

	}
}
