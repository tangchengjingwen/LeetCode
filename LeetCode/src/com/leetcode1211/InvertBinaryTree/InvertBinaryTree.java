package com.leetcode1211.InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//		Invert a binary tree.
//		
//		4
//		/   \
//		2     7
//		/ \   / \
//		1   3 6   9
//		to
//		4
//		/   \
//		7     2
//		/ \   / \
//		9   6 3   1
//
//Trivia:
//This problem was inspired by this original tweet by Max Howell:
//Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
public class InvertBinaryTree {
	//recursive
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
		
	}
	
	//iterative
	public TreeNode invertTree2(TreeNode root) {
		if(root==null) return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//remove()和poll()方法都是从队列中删除第一个元素。如果队列元素为空，调用remove()的行为与Collection接口的版本相似会抛出异常，
			//但是新的poll()方法在用空集合调用时只是返回null。因此新的方法更适合容易出现异常条件的情况。
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left!= null) queue.add(current.left);
			if (current.right!= null) queue.add(current.right);
		}
		return root;
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