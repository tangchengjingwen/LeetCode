package com.leetcode1215.ReverseVowelsOfAString;

//		
//		Write a function that takes a string as input and reverse only the vowels of a string.
//		
//		Example 1:
//		Given s = "hello", return "holle".
//		
//		Example 2:
//		Given s = "leetcode", return "leotcede".
//		
//		Note:
//		The vowels does not include the letter "y".
public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		char[] ch = s.toCharArray();
		int start = 0, end = ch.length - 1;
		char tmp;
		while (start < end) {
			if (checkVowel(ch[start]) && checkVowel(ch[end])) {
				tmp = ch[end];
				ch[end] = ch[start];
				ch[start] = tmp;
				start++;
				end--;
			} else {
				if (!checkVowel(ch[start])) {
					start++;
				}
				if (!checkVowel(ch[end])) {
					end--;
				}
			}
		}
		return new String(ch);
	}

	private boolean checkVowel(char c) {
		if ('a' == c || 'A' == c || 'e' == c || 'E' == c || 'i' == c || 'I' == c || 'o' == c || 'O' == c || 'u' == c
				|| 'U' == c)
			return true;
		return false;
	}
}
