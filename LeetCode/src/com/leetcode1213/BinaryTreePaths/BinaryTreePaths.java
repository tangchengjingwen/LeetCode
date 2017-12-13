package com.leetcode1213.BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

//		
//		Given a binary tree, return all root-to-leaf paths.
//		
//		For example, given the following binary tree:
//		
//		   1
//		 /   \
//		2     3
//		 \
//		  5
//		All root-to-leaf paths are:
//		
//		["1->2->5", "1->3"]
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new LinkedList<String>();
		StringBuffer sb = new StringBuffer();
		if(root==null) return result;
		path(root, result, sb);
		return result;
	}
	private void path(TreeNode root, List<String> result, StringBuffer sb) {
		if(root.left == null && root.right == null) {
			sb.append(root.val);
			result.add(sb.toString());
			return;
		}
		sb.append(root.val);
		sb.append("->");
		int len = sb.length();
		
		if(root.left != null) 
			path(root.left, result, sb);
		sb.setLength(len);
		if(root.right != null) {
			path(root.right, result, sb);
		}
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