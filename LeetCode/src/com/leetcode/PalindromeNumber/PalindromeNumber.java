package com.leetcode.PalindromeNumber;
//Determine whether an integer is a palindrome. Do this without extra space.

public class PalindromeNumber {
	
	public static boolean isPalindrome(int x) {
		if (x < 0 || x!=0 && x%10==0) {
			return false;
		}
		
		int reversed = 0;
		int origin = x;
		while(x != 0) {
			reversed = 10 * reversed + x % 10;
			x = x / 10;
		}
		return reversed == origin;
	}
	public static void main(String[] args) {
		int x = 12321;
		System.out.println("the number " + x + " is a " + isPalindrome(x) + " PalindromeNumber");
	}
}
