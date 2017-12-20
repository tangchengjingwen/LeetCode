package com.leetcode1220.StringToInteger_atoi;

//		Implement atoi to convert a string to an integer.
//		
//		Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//		
//		Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.


//		Requirements for atoi:
//		The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//		
//		The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//		
//		If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//		
//		If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
public class StringToInteger_atoi {
	public int myAtoi(String str) {
		if (str ==null || str.isEmpty()) return 0;
		str = str.trim();
		int n = str.length();
		if(n == 1 && (str.equals("+") || str.equals("-"))) return 0;
		int sign = 0; 
		if(str.charAt(0) == '+') {
			sign = 1;
		} else if (str.charAt(0) == '-') {
			sign = -1;
		}
		int index = (sign != 0 ) ? 1 : 0;
		if (index == 0) {
			sign = 1;
		}
		long res = 0;
		while(index < n) {
			char c = str.charAt(index);
			if (!Character.isDigit(c)) {
				return (int)res * sign;
			} 
			res = res * 10 + c - '0';
			if (res * sign > Integer.MAX_VALUE ) {
				return Integer.MAX_VALUE;
			}
			if (res * sign < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			index++;
		}
		return (int)res * sign;
		
	}
}
