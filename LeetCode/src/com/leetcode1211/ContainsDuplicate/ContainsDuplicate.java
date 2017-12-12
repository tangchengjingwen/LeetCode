package com.leetcode1211.ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//
//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, 
//and it should return false if every element is distinct.

public class ContainsDuplicate {
	// sorting
	public boolean containDuplicate(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

	// hash table
	public boolean containDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>(nums.length);

		for (int i : nums) {
			if (set.contains(i))
				return true;
			set.add(i);
		}
		return false;
	}
}
