package com.leetcode1220.MaximumProductSubarray;

//			Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//			
//			For example, given the array [2,3,-2,4],
//			the contiguous subarray [2,3] has the largest product = 6.
//			
//time: O(n)  space:O(1)
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
			min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
			res = Math.max(res, max);
		}
		return res;
	}
}
