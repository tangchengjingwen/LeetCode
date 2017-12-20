package com.leetcode1219.WordBreak;

import java.util.List;

//		
//		Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//		
//		For example, given
//		s = "leetcode",
//		dict = ["leet", "code"].
//		
//		Return true because "leetcode" can be segmented as "leet code".
//		
//		UPDATE (2017/1/4):
//		The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

//time:O(n^2)  space:O(n)
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
