package com.leetcode1210.NumberOf1Bits;

//Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
//
//For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3

//“a”的值是129，转换成二进制就是10000001，而“b”的值是128，转换成二进制就是10000000。根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128
//考的还是java & 运算符
public class NumberOf1Bits {
	public static int hammingWeight(int n) {
		int count = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0)
				count++;
			mask <<= 1;
		}
		return count;
	}
	public static void main(String[] args) {
		int n = 11;
		System.out.println(hammingWeight(n));
	}
}
