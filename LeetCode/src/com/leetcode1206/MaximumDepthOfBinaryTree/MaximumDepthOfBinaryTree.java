package com.leetcode1206.MaximumDepthOfBinaryTree;


//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
public class MaximumDepthOfBinaryTree {
	public int MaxDepth(TreeNode root) {
		if (root==null) return 0;
		return Math.max(curDepth(1, root.left), curDepth(1, root.right));
	}
	public static int curDepth(int cur, TreeNode root) {
		if (root==null) return cur;
		cur++;
		return Math.max(curDepth(cur, root.left), curDepth(cur, root.right));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}