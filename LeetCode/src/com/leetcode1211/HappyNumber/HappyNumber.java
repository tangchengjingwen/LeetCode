package com.leetcode1211.HappyNumber;

import java.util.HashSet;

//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n < 1)
			return false;
		// 保存中间出现的结果
		HashSet<Integer> set = new HashSet<Integer>(32);

		int tmp, newN;
		// n不能为1并且n的值不能重复出现在set中，否则进入死循环
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			newN = 0;
			while (n > 0) {
				tmp = n % 10;
				n = n / 10;
				newN = newN + tmp * tmp;
			}
			n = newN;
		}
		return n == 1;
	}
}
