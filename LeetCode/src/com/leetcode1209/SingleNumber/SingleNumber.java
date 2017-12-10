package com.leetcode1209.SingleNumber;



//Given an array of integers, every element appears twice except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class SingleNumber {
	//用异或来处理
	public static int singleNumber(int[] nums) {
		int begin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			begin ^= nums[i];
		}
		return begin;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,3,2,1};
		System.out.println(singleNumber(nums));
	}
}
