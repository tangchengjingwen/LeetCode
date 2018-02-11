package com.leetcode1209.MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {

	// 推荐 time:O(n) space:O(1)
	public int majorityElement(int[] nums) {
		int count = 0;
		int res = 0;
		for (int num : nums) {
			if (count == 0) {
				res = num;
			}
			if (num != res) {
				count--;
			} else {
				count++;
			}
		}
		return res;
	}

	// -----------------------------------------------------------------
	// hashmap time:O(n) sapce:O(n)
	public int majorityElement2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
			if (map.get(num) > nums.length / 2) {
				res = num;
				break;
			}
		}
		return res;
	}

	// ------------------------------------------------
	// sorting time: O(nlogn) space: O(1)
	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
