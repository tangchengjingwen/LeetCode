package com.leetcode1206.BalancedBinaryTree;
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//给定一棵平衡二叉树，判断它是否是高度平衡的。一棵高度平衡的二叉树是左右子树的高度相差不超过1，对其左右子树也是如此。

public class BalancedBinaryTree {
	public static  boolean isBalanced(TreeNode root) {
		if(root==null) 
			return true;
		int left = depth(root.left);
		int right = depth(root.right);
		
		if(left - right > 1 || left - right < -1) {
			return false;
		} else {
			return isBalanced(root.left) &&isBalanced(root.right);
		}
	}
	//返回树的深度
	private static int depth(TreeNode root) {
		if (root==null) {
			return 0;
		}
		 
		if(root.left==null && root.right==null) {
			return 1;
		}
		else {
			int left = depth(root.left);
			int right = depth(root.right);
			return 1 + (left > right ? left : right);
		}
	}
}




class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}