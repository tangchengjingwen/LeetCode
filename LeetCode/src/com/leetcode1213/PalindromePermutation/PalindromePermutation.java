package com.leetcode1213.PalindromePermutation;

import java.util.HashSet;
import java.util.Set;

//		
//		Given a string, determine if a permutation of the string could form a palindrome.
//		
//		For example,
//		"code" -> False, "aab" -> True, "carerac" -> True.
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		
		//set不允许重复，set.add(s.charAt(i))返回boolean值，如果不能添加则表示set
		//中已经存在，那么把set中值删除，最后如果为奇数的话size为1，偶数则为0，其他情况size大于1
		for(int i = 0; i < s.length(); i++) {
			if(!set.add(s.charAt(i))) {
				set.remove(s.charAt(i));
				
			}
		}
		return set.size() <=1;
	}
}
