package com.leetcode.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int ele = target - nums[i];
			if(hashMap.containsKey(ele) && hashMap.get(ele) != i) {
				return new int[] {i, hashMap.get(ele)};
			}
		}
		throw new IllegalArgumentException("no solution");
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15}; int target = 9;
		int[] twoSum = twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}
}
