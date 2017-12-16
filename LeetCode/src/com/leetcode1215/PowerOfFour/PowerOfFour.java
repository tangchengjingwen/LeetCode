package com.leetcode1215.PowerOfFour;

//
//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
//Example:
//Given num = 16, return true. Given num = 5, return false.
//
//Follow up: Could you solve it without loops/recursion?
public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		if (num < 1) {
			return false;
		}
		while (num % 4 == 0) {
			num = num / 4;
		}
		return num == 1;
	}

	// 思想是如果一个数为4的倍数，那么这个数-1一定可以被3整除，可以用数学归纳法很容易得到证明。
	public boolean isPowerOfFour2(int num) {
		if (num < 0)
			return false;
		int tmp = num - 1;

		return (num & tmp) == 0 && tmp / 3 == 0;
	}
}
