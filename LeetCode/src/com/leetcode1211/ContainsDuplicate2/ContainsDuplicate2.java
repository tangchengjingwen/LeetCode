package com.leetcode1211.ContainsDuplicate2;

import java.util.HashSet;
import java.util.Set;

//
//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j in the array 
//such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
public class ContainsDuplicate2 {

	// hash table
	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
        /*		Search current element in the HashTable, return true if found
				Put current element in the HashTable
				If the size of the HashTable is larger than kk, remove the oldest item.*/
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
	
}
