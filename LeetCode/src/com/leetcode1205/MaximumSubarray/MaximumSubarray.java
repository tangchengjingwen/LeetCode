package com.leetcode1205.MaximumSubarray;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6.
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum = nums[i] + (sum < 0 ? 0:sum);
        	max = sum > max ? sum:max;
        }
        return max;
    }

    public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	int maxSubArray = maxSubArray(nums);
    	System.out.println(maxSubArray);
	}
}
