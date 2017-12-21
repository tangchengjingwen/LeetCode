package com.leetcode1221.SingleElementInASortedArray;

/**
 * 
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once. Find this single element
 * that appears only once.
 * 
 * Example 1: Input: [1,1,2,3,3,4,4,8,8] Output: 2 Example 2: Input:
 * [3,3,7,7,10,11,11] Output: 10
 * 
 * @author tangc
 *time:O(n) space:O(1)
 */
public class SingleElementInASortedArray {
	//binary search
	public int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length/2;
		while(left < right) {
			int mid =  left + (right-left)/2;
			if(nums[2*mid] == nums[2*mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[2*left];
	}
}
