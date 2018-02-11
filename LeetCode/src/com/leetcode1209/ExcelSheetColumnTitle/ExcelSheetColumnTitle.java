package com.leetcode1209.ExcelSheetColumnTitle;

//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		StringBuilder s = new StringBuilder();
		while(n != 0) {
			int temp = (n-1) % 26;
			s = s.append((char)('A' + temp));
			n = (n-1) / 26;
		}
		return s.toString();
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(27));
		
	}
}
