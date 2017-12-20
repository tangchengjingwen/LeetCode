package com.leetcode1219.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//		
//		Given an array of strings, group anagrams together.
//		
//		For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//		Return:
//		
//		[
//		  ["ate", "eat","tea"],
//		  ["nat","tan"],
//		  ["bat"]
//		]
//		Note: All inputs will be in lower-case.
public class GroupAnagrams {
	// time O(m*n*logn) space O(n)
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();

		if (strs == null || strs.length == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch);
			if (map.containsKey(s)) {
				List<String> list = res.get(map.get(s));
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, res.size());
				res.add(list);
			}
		}
		return res;
	}
}
