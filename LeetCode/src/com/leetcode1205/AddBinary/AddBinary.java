package com.leetcode1205.AddBinary;


//
//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".
public class AddBinary {
	public static String addBinary(String a, String b) {
		int maxLen = Math.max(a.length(), b.length());
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < maxLen; i++) {
			// 从最右边开始逐位取出字符串a，b的字符值tempA和tempB，若长度不够用0代替
			int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
			int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;

			sb.insert(0, (tempA + tempB + carry) % 2);// 在最左边插入结果
			carry = tempA + tempB + carry > 1 ? 1 : 0;//进位
		}
		if(carry == 1) 
			sb.insert(0, 1);//循环结束如果有进位，在加一
		return sb.toString();
	}
	public static void main(String[] args) {
		String a = "1111", b = "1";
		System.out.println(addBinary(a, b));
	}
}
