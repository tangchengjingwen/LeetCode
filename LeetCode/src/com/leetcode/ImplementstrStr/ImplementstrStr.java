package com.leetcode.ImplementstrStr;

//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//Example 1:
//
//Input: haystack = "hello", needle = "ll"
//Output: 2
//Example 2:
//
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
public class ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String haystack = "aaaaa"; String needle = "bba";
		System.out.println(strStr(haystack, needle));
	}
}
