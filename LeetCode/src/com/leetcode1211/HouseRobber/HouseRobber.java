package com.leetcode1211.HouseRobber;

//	
//	//You are a professional robber planning to rob houses along a street. 
//	Each house has a certain amount of money stashed, the only constraint
//	stopping you from robbing each of them is that adjacent houses have security
//	system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//	//
//	//Given a list of non-negative integers representing the amount of money of each house,
//	determine the maximum amount of money you can rob tonight without alerting the police.

//   f(k) = max(f(k – 2) + Ak, f(k – 1))
public class HouseRobber {
	public int rob(int[] nums) {
		int prevMax = 0;
		int currMax = 0;
		for (int i : nums) {
			int temp = currMax;
			currMax = Math.max(prevMax + i, currMax);
			prevMax = temp;
		}
		return currMax;
	}
}
