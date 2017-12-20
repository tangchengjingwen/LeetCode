package com.leetcode1219.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

//			
//			
//			Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//			
//			For example, given n = 3, a solution set is:
//			
//			[
//			  "((()))",
//			  "(()())",
//			  "(())()",
//			  "()(())",
//			  "()()()"
//			]
// time O(n!) (2^n)   space:O(n) 
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", n, n);
		return res;
	}

	private void helper(List<String> res, String s, int left, int right) {
		if (left > right) {
			return;
		}
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		if (left > 0) {
			helper(res, s + "(", left - 1, right);
		}
		if (right > 0) {
			helper(res, s + ")", left, right - 1);
		}
	}
}
