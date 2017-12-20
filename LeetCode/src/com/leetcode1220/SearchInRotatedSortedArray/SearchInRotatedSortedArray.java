package com.leetcode1220.SearchInRotatedSortedArray;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


 * @author tangc
 *
 */

//time:O(logn) space:O(1)
public class SearchInRotatedSortedArray {
	public int serach(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		int start = 0;
		int end = nums.length - 1;
		while(start+1 < end) {
			int mid = start + (end-start)/2;
			if(nums[mid] == target) return mid;
			if(nums[start] < nums[mid]) {
				if(nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else start = mid;
			} else {
				if(nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else end = mid;
			}
		}
		if(nums[start] == target) return start;
		if(nums[end] == target) return end;
		return -1;
	}
}
