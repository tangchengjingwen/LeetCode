package com.leetcode1220.FindMinimumInRotatedSortedArray;

//			
//			Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//			
//			(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//			
//			Find the minimum element.
//			
//			You may assume no duplicate exists in the array.
//			

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length <0) throw new IllegalArgumentException();
		return binarySearch(nums, 0, nums.length -1);
	}

	private int binarySearch(int[] nums, int start, int end) {
		int mid = 0;
		while(start < end) {
			mid = start + (end-start)/2;
			//如果后一个数比前一个数小则找到
			if(nums[mid] > nums[mid+1]) {
				return nums[mid+1];
			} else if (nums[mid] > nums[start]) {
				//说明nums[mid] 还在第一个有序数组中
				start = mid;
			} else {
				//说明在第二个有序数组中
				end = mid;
			}
			
		}
		return nums[0];
	}
}
