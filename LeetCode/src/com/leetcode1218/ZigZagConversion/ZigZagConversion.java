package com.leetcode1218.ZigZagConversion;

//		
//		The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//		
//		P   A   H   N
//		A P L S I I G
//		Y   I   R
//		And then read line by line: "PAHNAPLSIIGYIR"
//		Write the code that will take a string and make this conversion given a number of rows:
//		
//		string convert(string text, int nRows);
//		convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
//
//这道题就是看坐标的变化。并且需要分块处理。
//
//n=2时，字符串坐标变成zigzag的走法就是：
//
//0 2 4 6
//
//1 3 5 7
//
//n=3时的走法是：
//
//0     4     8
//
//1  3 5  7 9
//
//2     6    10 
//
//n=4时的走法是：
//
//0      6        12
//
//1   5 7    11 13
//
//2 4   8 10    14
//
//3      9         15 
//
//
//
//可以发现规律，画红色的长度永远是 2n-2 （想法是你试想把所有这些行压缩成两列，两边手挤一下，第二列永远的第一行和最后一行少字）。
//
//利用这个规律，可以按行填字，第一行和最后一行，就是按照2n-2的顺序一点点加的。
//
//其他行除了上面那个填字规则，就是还要处理斜着那条线的字，可以发现那条线的字的位置永远是当前列j+(2n-2)-2i(i是行的index）。 
//
//按照上面的规律就可以写出代码了。
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows <= 0) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		int size = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				sb.append(s.charAt(j));
				if (i != 0 && i != numRows - 1) {
					// 处理斜线
					int tmp = j + size - 2 * i;
					if (tmp < s.length()) {
						sb.append(s.charAt(tmp));
					}
				}
			}
		}
		return sb.toString();
	}
}
