package com.leetcode1221.UniqueBinarySearchTrees;


/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author tangc
 *
 */
//画图找规律即可
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n < 1) return 0;
		int[] nums = new int[n+1];
		nums[0] = 1; nums[1] = 1;
		for(int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				nums[i] = nums[i] + (nums[i-j-1]*nums[j]);
			}
		}
		return nums[n];
	}
}
