package com.leetcode1219.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//
//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.
//

public class LetterCombinationsOfAPhoneNumber {
	private String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	// back tracking
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return res;
		}
		helper(res, digits, "", 0);
		return res;
	}

	private void helper(List<String> res, String digits, String s, int index) {
		if(index == digits.length()) {
			res.add(s);
			return;
		}
		String letters = mapping[s.charAt(index)-'0'];
		for(int i = 0; i < letters.length(); i++) {
			helper(res, digits, s + letters.charAt(i), index + 1);
		}
	}
	
	
	//---------------------------------------
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if(digits == null || digits.length() ==0) {
			return res;
		}
		
		String[] mapping1 = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		res.add("");
		for(int i = 0; i < digits.length(); i++) {
			int num = digits.charAt(i) - '0';
			while(res.peek().length() == i) {
				String t = res.remove();
				for(char s : mapping1[num].toCharArray()) {
					res.add(t + s);
				}
			}
		}
		return res;
	}
}
