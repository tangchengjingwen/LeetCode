package com.leetcode1226.FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example: Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 * 
 * @author tangc
 *time:O(n) space:O(1)
 */
//出现过一次就标记为负数，如果再次访问到就添加到最后的结果
public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				res.add(Math.abs(index + 1));
			}
			nums[index] = -nums[index];
		}
		return res;
	}
}
