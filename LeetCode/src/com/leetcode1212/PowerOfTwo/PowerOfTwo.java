package com.leetcode1212.PowerOfTwo;

//Given an integer, write a function to determine if it is a power of two.
public class PowerOfTwo {

	// 递归
	public boolean isPowerOfTwo(int n) {
		if (n == 1)
			return true;
		if (n >= 2 && n % 2 == 0) {
			return isPowerOfTwo(n / 2);
		}
		return false;
	}

	// 位运算，是2的幂，则二进制数有且只有一个1
	public boolean isPowerOfTwo2(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}
}
