package com.leetcode1205.LengthofLastWord;

//
//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//Example:
//
//Input: "Hello World"
//Output: 5
// 从后往前，注意去除末尾的空字符。
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
    	return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
    public static void main(String[] args) {
		String s = "Hello dilireba ";
		int i = lengthOfLastWord(s);
		System.out.println(i);
    }
}
