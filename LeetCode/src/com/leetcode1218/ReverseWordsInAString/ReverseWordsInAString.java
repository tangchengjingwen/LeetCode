package com.leetcode1218.ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;

//	
//	Given an input string, reverse the string word by word.
//	
//	For example,
//	Given s = "the sky is blue",
//	return "blue is sky the".
public class ReverseWordsInAString {

	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;

		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}

	public String reverseWords2(String s) {
		if (s == null || s.length() == 0)
			return s;

		char[] arr = s.toCharArray();
		int n = arr.length;
		// 翻转整个arr
		reverse(arr, 0, n - 1);
		// 翻转每个单词
		reverseEachWord(arr, n);
		// clean spaces
		return cleanSpace(arr, n);

	}

	private String cleanSpace(char[] arr, int n) {
		int i = 0, j = 0;
		while (j < n) {
			while (j < n && arr[j] == ' ')
				j++;
			while (j < n && arr[j] != ' ')
				arr[i++] = arr[j++];
			while (j < n && arr[j] == ' ')
				j++;
			if (j < n)
				arr[i++] = ' ';
		}
		return new String(arr).substring(0, i);
	}

	private void reverseEachWord(char[] arr, int n) {
		// pointer to jump spaces
		int i = 0;
		// pointer to jump non-spaces;
		int j = 0;
		while (i < n) {
			while (i < j || (i < n && arr[i] == ' '))
				i++;
			while (j < i || (j < n && arr[j] != ' '))
				j++;
			reverse(arr, i, j - 1);
		}
	}

	private void reverse(char[] arr, int i, int j) {
		while (i < j) {
			char tmp = arr[j];
			arr[i++] = arr[j];
			arr[j--] = tmp;
		}

	}
}
