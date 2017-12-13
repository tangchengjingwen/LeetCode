package com.leetcode1213.AddDigits;

//		Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//		
//		For example:
//		
//		Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
//		
//		Follow up:
//		Could you do it without any loop/recursion in O(1) runtime?
public class AddDigits {

	public int addDigits(int num) {
		while (num / 10 > 0) {
			int result = 0;
			int tmp = num;
			while (tmp != 0) {
				result += (tmp % 10);
				tmp /= 10;
			}
			num = result;
		}
		return num;
	}

	public int addDigits2(int num) {
		while(num >=10) {
			num = num/10 + num%10;
		}
		return num;
	}

	public int addDigits3(int num) {
		return 1 + (num - 1) % 9;
	}
}
