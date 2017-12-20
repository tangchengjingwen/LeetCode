package com.leetcode1219.SingleNumberII;

import java.util.Arrays;

//		Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//		
//		Note:
//		Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//		

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int i = 0; i < nums.length; i++) {
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
	}

	public int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1)
			return nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				i = i + 2;
			} else {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}
}
