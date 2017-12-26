package com.leetcode1225.NextPermutation;


/**
			 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
			
			If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
			
			The replacement must be in-place, do not allocate extra memory.
			
			Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
			1,2,3 → 1,3,2
			3,2,1 → 1,2,3
			1,1,5 → 1,5,1
			
			//1    2     7     4      3     1
			       ^
		//    1    2     7     4      3     1
		 						      ^
//            1    3     7     4      2     1
 //                ^                  ^
  			  1    3     1     2      4     7
  			  			 ^     ^      ^     ^
			
			
 * @author tangc
 *time:O(n)  space:O(1)
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		int firstSmall = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i+1]) {
				firstSmall = i;
				break;
			}
		}
		
		if (firstSmall == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		
		int firstLarge = -1;
		for (int i = nums.length - 1; i > firstSmall; i--) {
			if (nums[i] > nums[firstSmall]) {
				firstLarge = i;
				break;
			}
		}
		swap(nums, firstSmall, firstLarge);
		reverse(nums, firstSmall + 1, nums.length - 1);
		return;
		}
	

		private void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			
		}

		private void reverse(int[] nums, int i, int j) {
			while (i < j) {
				swap(nums, i++, j--);
			}
			
		}
}
