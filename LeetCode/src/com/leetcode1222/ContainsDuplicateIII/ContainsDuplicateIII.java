package com.leetcode1222.ContainsDuplicateIII;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * @author tangc
 *Time complexity : O(nlog(min(n,k)))  Space complexity : O(min(n,k))
 */


public class ContainsDuplicateIII {
	/**
	 * binary search tree
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicates(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Integer s = set.ceiling(nums[i]);
			// Find the successor of current element
			if (s!= null && s <= nums[i] + t) return true;
			// Find the predecessor of current element
			Integer g = set.floor(nums[i]);
			if (g != null && nums[i] <= g + t) return true;
			
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}	
