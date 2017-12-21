package com.leetcode1221.DivideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author tangc
 *
 */
public class DivideTwoIntegers {
	public int divide (int dividend, int divisor) {
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
		long Ldividend = Math.abs((long)dividend);
		long Ldivisor = Math.abs((long)divisor);
		if (Ldividend < Ldivisor || Ldividend == 0) return 0;
		long lres = divide(Ldividend, Ldivisor);
		int res = 0;
		if (lres > Integer.MAX_VALUE)  {
			res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			res = (int)(sign * lres);
		}
		return res;
	}

	private long divide(long ldividend, long ldivisor) {
		if (ldividend < ldivisor) return 0;
		long sum = ldivisor;
		int multiple = 1;
		while ((sum + sum) < ldividend) {
			sum = sum + sum;
			multiple += multiple;
		}
		return multiple + divide(ldividend - sum, ldivisor);
	}
}

