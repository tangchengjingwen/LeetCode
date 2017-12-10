package com.leetcode1209.MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {
	
	//暴力法
	public int majorityElement(int[] nums) {
		int majorityCount = nums.length/2;
		for (int num : nums) {
			int count = 0;
			for (int ele : nums) {
				if(ele == num) {
					count += 1;
				}
			}
			if(count > majorityCount) {
				return num;
			}
		}
		return -1;
	}
	//-----------------------------------------------------------------
	//hashmap
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> counts = countNums(nums);
		
		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if(majorityEntry == null || entry.getValue()>majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}
		return majorityEntry.getKey();
	}
	private Map<Integer,Integer> countNums(int[] nums) {
		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
		for(int num : nums) {
			if(!counts.containsKey(num)) {
				counts.put(num, 1);
			} else {
				counts.put(num, counts.get(num)+1);
			}
		}
		return counts;
	}
	
	//------------------------------------------------
	//sorting
	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}
