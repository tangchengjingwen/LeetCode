package com.leetcode1221.ShuffleAnArray;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3. int[] nums = {1,2,3}; Solution
 * solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation of
 * [1,2,3] must equally likely to be returned. solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3]. solution.shuffle();
 * 
 * @author tangc
 *
 *
 *TIME:O(n)
 */
public class ShuffleAnArray {
	
	private int[] nums;
	private Random rdm;
	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
		rdm = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if(nums == null) return nums;
		int[] clone = nums.clone();
		for(int i = 1; i < clone.length; i++) {
			int random = rdm.nextInt(i+1);
			swap(clone, i, random);
		}
		return clone;
	}

	private void swap(int[] clone, int i, int j) {
		int tmp = clone[i];
		clone[i] = clone[j];
		clone[j] = tmp;
	}
}
