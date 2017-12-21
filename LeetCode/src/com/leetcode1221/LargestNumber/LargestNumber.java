package com.leetcode1221.LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * Credits:
 * 
 * @author tangc
 *time:O(logn) space:O(n)
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";
		String[] res = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(res, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}

		});
		if (res[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String s : res) {
			sb.append(s);
		}
		return sb.toString();
	}

}
