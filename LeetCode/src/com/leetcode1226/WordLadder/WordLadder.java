package com.leetcode1226.WordLadder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is "hit"
 * -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters. You
 * may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same.
 * 
 * @author tangc
 *time:O(n) space:O(n)
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList);
		if (set.contains(beginWord)) {
			set.remove(beginWord);
		}

		Queue<String> queue = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		map.put(beginWord, 1);
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int curLevel = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] wordUnit = word.toCharArray();
				// 每次改变一个字符然后判断是否在set中
				for (char j = 'a'; j <= 'z'; j++) {
					wordUnit[i] = j;
					String tmp = new String(wordUnit);
					if (set.contains(tmp)) {
						if (tmp.equals(endWord)) {
							return curLevel + 1;
						} else {
							map.put(tmp, curLevel + 1);
							queue.offer(tmp);
							set.remove(tmp);
						}
					}
				}
			}
		}
		return 0;
	}
}
