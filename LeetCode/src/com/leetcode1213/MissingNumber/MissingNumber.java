package com.leetcode1213.MissingNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//	
//	Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//	
//	Example 1
//	
//	Input: [3,0,1]
//	Output: 2
//	Example 2
//	
//	Input: [9,6,4,2,3,5,7,0,1]
//	Output: 8
//	
//	Note:
//	Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

public class MissingNumber {
	// sorting
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		// ensure that n is last index
		if (nums[nums.length - 1] != nums.length)
			return nums.length;
		// ensure 0 is first index
		else if (nums[0] != 0)
			return 0;

		for (int i = 1; i < nums.length; i++) {
			int expectValue = nums[i - 1] + 1;
			if (nums[i] != expectValue)
				return expectValue;
		}

		return -1;
	}

	// hashset
	public int missingNumber2(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums)
			numSet.add(num);
		// n = nums.length
		int expectedNumCount = nums.length + 1;
		for (int number = 0; number < expectedNumCount; number++) {
			if (!numSet.contains(number)) {
				return number;
			}
		}
		return -1;
	}

}
