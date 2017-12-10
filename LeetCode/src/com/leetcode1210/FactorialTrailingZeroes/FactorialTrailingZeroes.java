package com.leetcode1210.FactorialTrailingZeroes;
//

//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in logarithmic time complexity.

//
//关于N的阶乘后面有几个0，即Factorial Trailing Zeroes。
//分解因子，当且出现一对2和5时，末尾添加一个0。且因子2多于因子5，固计算N的因子中包含多少5.
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n <= 0)
			return 0;
		int count = 0;
		while (n / 5 != 0) {
			n = n / 5;
			count = count + n;
		}
		return count;
	}
}
