package com.leetcode1219.PowOfXN;

//		
//		Implement pow(x, n).
//		
//		
//		Example 1:
//		
//		Input: 2.00000, 10
//		Output: 1024.00000
//		Example 2:
//		
//		Input: 2.10000, 3
//		Output: 9.26100
public class PowerOfXN {
	// 递归
	public double myPow(double x, int n) {
		if (n > 0) {
			return pow(x, n);
		} else {
			return 1.0 / pow(x, n);
		}

	}

	private double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double y = pow(x, n / 2);
		if (n % 2 == 0) {
			return y * y;
		} else {
			return y * y * x;
		}
	}

	// -------------------迭代
	public double myPow2(double x, int n) {
		if (n == 0)
			return 1;
		double res = 1;
		// int -2^32 ~ 2^32-1 所以如果n为负数，可能会overflow
		long abs = Math.abs((long) n);
		while (abs > 0) {
			if (abs % 2 != 0) {
				res = res * x;
			}
			x = x * x;
			abs = abs / 2;
		}
		if (n < 0) {
			return 1.0 / res;
		}
		return res;
	}

}
