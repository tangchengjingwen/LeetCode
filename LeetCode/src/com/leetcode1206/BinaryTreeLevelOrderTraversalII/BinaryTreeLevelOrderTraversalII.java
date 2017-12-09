package com.leetcode1206.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//	
//	For example:
//	Given binary tree [3,9,20,null,null,15,7],
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
//	return its bottom-up level order traversal as:
//	[
//	  [15,7],
//	  [9,20],
//	  [3]
//	]
public class BinaryTreeLevelOrderTraversalII {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		levelRecursion(root, result,0);
		return result;
	}
	public static void levelRecursion(TreeNode node, LinkedList<List<Integer>> result, int level) {
		if(node==null) return;
		if (result.size() < level+1) result.addFirst(new ArrayList<Integer>());
		result.get(result.size() - 1 - level).add(node.val);
		
		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);	
	}
		
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(levelOrderBottom(root));
		
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}
