package com.leetcode1206.ConvertSortedArrayToBinarySearchTree;


//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//Example:
//
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class ConvertSortedArrayToBinarySearchTree {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums==null || nums.length==0) {
			return null;
		}
		//递归得到AVL树
		return innerHelper(nums, 0, nums.length-1);
	}
	private static TreeNode innerHelper(int[] nums, int begin, int end) {
		if(begin > end) {
			return null;
		}
		//每次取中间节点作为根节点
		int mid = (begin + end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		//用根节点的左侧的数生成左边子树
		root.left = innerHelper(nums, begin, mid - 1);
		//用根节点的右侧的数生成左边子树
		root.left = innerHelper(nums, mid + 1, end);	
		return root;
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}