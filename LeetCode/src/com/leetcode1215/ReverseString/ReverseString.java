package com.leetcode1215.ReverseString;

//		
//		Write a function that takes a string as input and returns the string reversed.
//		
//		Example:
//		Given s = "hello", return "olleh".
public class ReverseString {
	public String reverseString(String s) {
		char[] chars = new char[s.length()];
		int index = 0;
		
		for(int i = s.length() -1; i >=0;i--) {
			chars[index] = s.charAt(i);
			index++;
			//    chars[index++] = s.charAt(i);
		}
		return new String(chars);
	}
	
	public String reverseString2(String s) {
		return new StringBuffer(s).reverse().toString();
	}
}
