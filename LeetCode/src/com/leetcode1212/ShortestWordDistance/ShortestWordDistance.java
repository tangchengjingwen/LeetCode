package com.leetcode1212.ShortestWordDistance;

//	Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//	
//	For example,
//	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//	
//	Given word1 = “coding”, word2 = “practice”, return 3.
//	Given word1 = "makes", word2 = "coding", return 1.
//	
//	Note:
//	You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int p = -1;
		int q = -1;
		int minDistance = words.length;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p = i;
			} else if (words[i].equals(word2)) {
				q = i;
			}
			if (p != -1 && q != -1) {
				minDistance = Math.min(minDistance, Math.abs(p - q));
			}
		}
		return minDistance;
	}

	// 暴力法
	public int shortestDistance2(String[] words, String word1, String word2) {
		int minDisatnce = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 0; j < words.length; j++) {
					if (words[j].equals(word2)) {
						minDisatnce = Math.min(minDisatnce, Math.abs(i - j));
					}
				}
			}
		}
		return minDisatnce;
	}
}
