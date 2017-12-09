package com.leetcode1208.MinimumDepthOfBinaryTree;


//Given a binary tree, find its minmum depth.
//
//The minmum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null) return minDepth(root.right) + 1;
		if(root.right==null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

}




class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}