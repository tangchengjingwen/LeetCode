package com.leetcode1205.SqrtX;
//Implement int sqrt(int x).
//
//Compute and return the square root of x.
//
//x is guaranteed to be a non-negative integer.
//Example 1:
//
//Input: 4
//Output: 2
//Example 2:
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
public class SqrtX {
	//平方根的值按规律不会大于它的中值+1，采用二分法
	public static int mySqrt(int x) throws Exception {
		long low = 0;
		long high = x/2 + 1;
		long tmp;
		long mid = 1;
		if (x < 0) 
			throw new Exception();
		if (x==0) {
			return 0;
		}
		while (low <= high) {
			mid = (low + high) /2;
			tmp = mid * mid;
			if (tmp == x) 
				return (int)mid;
			else if (tmp > x) 
				high = mid - 1;
			else if (tmp < x) 
				low = mid + 1;
		}
		return (int)high;
		
	}
	public static void main(String[] args) throws Exception {
		int x = 4;
		System.out.println(mySqrt(x));
	}
}
