package com.leetcode1215.RangeSumQuery_Immutable;



//	Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//	
//	Example:
//	Given nums = [-2, 0, 3, -5, 2, -1]
//	
//	sumRange(0, 2) -> 1
//	sumRange(2, 5) -> -1
//	sumRange(0, 5) -> -3
//	Note:
//	You may assume that the array does not change.
//	There are many calls to sumRange function.

public class RangeSumQuery_Immutable {
//	private int[] data;
//	public RangeSumQuery_Immutable(int[] nums) {
//		data = nums;
//	}
//	
//	public int sumRange(int i , int j) {
//		int sum = 0;
//		for(int k = i; k <= j ; k++) {
//			sum = sum + data[k];
//		}
//		return sum;
//	}
	
	private int[] sum;
	
	public RangeSumQuery_Immutable(int[] nums) {
		sum = new int[nums.length+1];
		for(int i = 0; i < nums.length; i++) {
			sum[i+1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j+1] - sum[i];
	}
}

