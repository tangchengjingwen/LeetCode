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
	public String convertToTitle(int n) {
		String s = "";
		while(n != 0) {
			int temp = (n-1) % 26;
			s = (char)('A' + temp) + s;
			n = (n-1) / 26;
		}
		return s;
	}

}
