package com.leetcode1211.IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.
//

public class IsomorphicStrings {
	// 使用一个hashmap保存映射关系，同时使用一个set保证一个character不能被映射到两个字符上
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);

			if (map.containsKey(sc)) {
				if (map.get(sc) == tc) {
					continue;
				} else {
					return false;
				}
			} else {
				if (set.contains(tc)) {
					return false;
				} else {
					map.put(sc, tc);
					set.add(tc);
				}
			}
		}

		return true;

	}
}
