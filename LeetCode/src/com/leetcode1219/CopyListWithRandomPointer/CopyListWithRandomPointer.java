package com.leetcode1219.CopyListWithRandomPointer;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

//Return a deep copy of the list.
//
//这个方法比较难想出来，不需要额外空间，不那么直观。直接上图比较好理解。分3步：
//1，复制节点，并将拷贝后的节点放到原节点的后面。
//2，更新所有拷贝节点的random节点：h.next.random = h.random.next。
//3，将原链表与复制链表断开。

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode h = head;
		while (h != null) {
			RandomListNode copy = new RandomListNode(h.lable);
			RandomListNode next = h.next;
			h.next = copy;
			copy.next = next;
			h = next;
		}

		h = head;
		while (h != null) {
			if (h.random != null) {
				h.next.random = h.random.next;
			}
			h = h.next.next;
		}

		h = head;
		RandomListNode newHead = h.next;
		while (h != null) {
			RandomListNode copy = h.next;
			h.next = copy.next;
			h = h.next;
			copy.next = h != null ? h.next : null;
		}
		return newHead;
	}
}

class RandomListNode {
	int lable;
	RandomListNode next, random;

	RandomListNode(int x) {
		lable = x;
	}
}