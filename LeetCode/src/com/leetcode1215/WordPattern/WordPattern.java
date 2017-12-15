package com.leetcode1215.WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] s = str.split(" ");
		if(pattern.length() != s.length) {
			return false;
		}
		
		HashMap<Character, String> map = new HashMap<Character,String>();
		Set<String> unique = new HashSet<String>();
		
		for(int i = 0; i < pattern.length(); i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(s[i])) {
					return false;
				}
			} else {
				//避免pattern中的两个字符对应到同一个str
				if(unique.contains(s[i])) {
					return false;
				}
				map.put(pattern.charAt(i), s[i]);
				unique.add(s[i]);
				
			}
			
		}
		return true;
	}
}
