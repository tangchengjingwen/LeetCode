package com.leetcode1215.PowerOfThree;

//		
//		Given an integer, write a function to determine if it is a power of three.
//		
//		Follow up:
//		Could you do it without using any loop / recursion?
public class PowerOfThree {
	// loop
	public boolean isPowerOfThree(int n) {
		if (n < 1) {
			return false;
		}
		while (n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

	// 3^19 = 1162261467
	public boolean isPowerOfThree2(int n) {
		return n > 0 && 1162261467 % n == 0;
	}
}
