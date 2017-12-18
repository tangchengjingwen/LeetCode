package com.leetcode1218.LongestPalindromicSubstring;
//		

//		
//		Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//		
//		Example:
//		
//		Input: "babad"
//		
//		Output: "bab"
//		
//		Note: "aba" is also a valid answer.
//		Example:
//		
//		Input: "cbbd"
//		
//		Output: "bb"

//对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，
//例如aba是回文，abba也是回文，这两种情况要分情况考虑）往两边同时进 行扫描，直到不是回文串为止。
//假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
//对于每个中心往两边扫描的复杂 度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)。
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.isEmpty() || s == null || s.length() == 1) {
			return s;
		}
		String max = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			String tmp = helper(s, i, i);
			if (tmp.length() > max.length()) {
				max = tmp;
			}

			tmp = helper(s, i, i + 1);
			if (tmp.length() > max.length()) {
				max = tmp;
			}
		}
		return max;
	}

	private String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
}
