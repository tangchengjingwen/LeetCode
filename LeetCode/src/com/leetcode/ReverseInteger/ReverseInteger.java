package com.leetcode.ReverseInteger;

//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//
//Input: 123
//Output:  321
//Example 2:
//
//Input: -123
//Output: -321
//Example 3:
//
//Input: 120
//Output: 21
//Note:
//Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


public class ReverseInteger {
	public static int reverse(int x) {
		long res = 0;
		
		int sign = x > 0 ? 1 : -1;
		
		long x0 = x;
		if (sign == -1) {
			x0 = x * -1;
		}
		
		while(x0 > 0) {
			long digit = x0 % 10;
			res = 10 * res + digit;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			x0 = x0 / 10;
		}
		return (int)(res * sign);
	
	}
	public static void main(String[] args) {
		int x = 123;
		System.out.println("the reverse of " + x + " is: " + reverse(x));
	}
	
}
