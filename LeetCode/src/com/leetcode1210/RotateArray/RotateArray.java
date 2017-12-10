package com.leetcode1210.RotateArray;

import java.util.Arrays;

//
//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
//[show hint]
//
//Hint:
//Could you do it in-place with O(1) extra space?
//Related problem: Reverse Words in a String II
public class RotateArray {
	//暴力法
	public static void rotate(int[] nums, int k) {
		int temp, previous;
		for(int i = 0; i < k; i++) {
			previous = nums[nums.length-1];
			for(int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = previous;
				previous = temp;
			}
		}
	}
//	//reverse
//	Original List                   : 1 2 3 4 5 6 7
//	After reversing all numbers     : 7 6 5 4 3 2 1
//	After reversing first k numbers : 5 6 7 4 3 2 1
//	After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
	public static void rotate2(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	
	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++; end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		System.out.println(Arrays.toString(nums));
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));
		
		int[] nums2 = {1,2,3,4,5,6,7};
		rotate2(nums2, k);
		System.out.println(Arrays.toString(nums2));
	}
}
