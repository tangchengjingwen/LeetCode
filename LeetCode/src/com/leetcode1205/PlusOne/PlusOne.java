package com.leetcode1205.PlusOne;

import java.util.Arrays;

//Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//
//You may assume the integer do not contain any leading zero, except the number 0 itself.
//
//The digits are stored such that the most significant digit is at the head of the list.
//

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		if (digits.length == 0)
			return digits;
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		// 能走到这一步一定是9,9，9,9.......
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
		
	}

	public static void main(String[] args) {
		
		int[] digits = {9,9,8};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
}
