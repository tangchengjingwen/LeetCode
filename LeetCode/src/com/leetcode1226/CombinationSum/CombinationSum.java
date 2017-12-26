package com.leetcode1226.CombinationSum;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 * 
 * @author tangc
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length < 1) {
			return res;
		}
		Arrays.sort(candidates);
		backTrack(candidates, target, res, new ArrayList<Integer>(), 0);
		return res;
	}

	private void backTrack(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> list,
			int start) {
		if (target < 0) return;
		if (target == 0) {
			res.add(list);
			return;
		}
		
		for (int i = start; i < nums.length && target >= nums[i]; i++) {
			list.add(nums[i]);
			backTrack(nums, target - nums[i], res, new ArrayList<Integer>(list), i);
			list.remove(list.size() - 1);
		}
	}
}
