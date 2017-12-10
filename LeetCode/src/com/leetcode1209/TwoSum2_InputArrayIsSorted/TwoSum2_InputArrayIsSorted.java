package com.leetcode1209.TwoSum2_InputArrayIsSorted;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2


 
public class TwoSum2_InputArrayIsSorted {
	//map
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < numbers.length; i++) {
			if(map.containsKey(numbers[i])) {
				res[0] = map.get(numbers[i]) + 1;
				res[1] = i + 1;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return res;
	}
	//数组是升序排列，设start初始值为0，end初始值为numbers.length-1，
//	先计算numbers中start，end对应两个数的和，如果比target大，end– -，如果比target小，start++
	public int[] twoSum2(int[] numbers, int target) {
		int res[] = new int[2];
		int start = 0, end = numbers.length-1;
		while (numbers[start] + numbers[end] != target) {
			if(numbers[start] + numbers[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		res[0] = start + 1;
		res[1] = end + 1;
		return res;
	}
	
}
