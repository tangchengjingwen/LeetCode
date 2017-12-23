package com.leetcode1222.SingleNumberIII;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?s
 * 
 * @author tangc
 *
 */
public class SingleNumberIII {
	public  int[] singelNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) {
			//出现两次的数就会抵消，剩下的就是两个只出现一次的数
			diff ^= num;
		}
		//别问为什么，记住！
		diff &= -diff;
		int[] res = new int[2];
		for (int num : nums) {
			if ((num & diff) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}
		return res;
	}
}
