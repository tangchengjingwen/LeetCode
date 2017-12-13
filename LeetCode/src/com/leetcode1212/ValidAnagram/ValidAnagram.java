package com.leetcode1212.ValidAnagram;

import java.util.Arrays;

//

//
//
//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//
//Note:
//You may assume the string contains only lowercase alphabets.
//
//Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?
//

public class ValidAnagram {
	// hashtable
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] counter = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int i : counter) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	// sorting
	public boolean isAnagram2(String s, String t ) {
		if(s.length()!=t.length()) return false;
		
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
 	
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
		
	}
}
