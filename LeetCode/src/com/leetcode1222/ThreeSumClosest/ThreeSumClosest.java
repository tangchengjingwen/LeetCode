package com.leetcode1222.ThreeSumClosest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author tangc
 *time: O(n^2) space: O(1)
 */
public class ThreeSumClosest {
	public int threeSumClosest (int[] nums, int target) {
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else start++;
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		return res;
	}
}
