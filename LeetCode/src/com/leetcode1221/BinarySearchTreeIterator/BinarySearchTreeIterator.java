package com.leetcode1221.BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author tangc
 *
 */
public class BinarySearchTreeIterator {

	private TreeNode cur;
	private Stack<TreeNode> stack;

	public BinarySearchTreeIterator(TreeNode root) {
		cur = root;
		stack = new Stack<>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (!stack.isEmpty() || cur != null)
			return true;
		return false;
	}

	/** @return the next smallest number */
	public int next() {
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		cur = stack.pop();
		int val = cur.val;
		cur = cur.right;
		return val;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}