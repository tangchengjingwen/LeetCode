package com.leetcode1221.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author tangc
 *time:O(n! *n) space:O(n)
 */
public class Permutations {
	public List<List<Integer>> permute (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		helper(res, new ArrayList<>(), nums);
		return res;
		
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) continue;
			list.add(nums[i]);
			helper(res, list,nums);
			list.remove(list.size() - 1);
		}
	}
}
