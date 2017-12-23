package com.leetcode1222.FindTheDuplicateNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * @author tangc
 *
 */
public class FindTheDuplicateNumber {
	//sorting time:O(nlogn) space:0(1)
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1]) {
				return nums[i];
			}
		}
		return -1;
	}
	
	//set time:O(n) space:O(n)
	public int findDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}
	
	//
}
