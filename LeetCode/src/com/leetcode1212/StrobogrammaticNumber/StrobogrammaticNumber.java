package com.leetcode1212.StrobogrammaticNumber;

import java.util.HashMap;

//	
//	A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//	
//	Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//	
//	For example, the numbers "69", "88", and "818" are all strobogrammatic.
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');

		int left = 0, right = num.length() - 1;
		//这里取整数为了防止num只有一个数字
		while (left <= right) {
			if (!map.containsKey(num.charAt(left)) || !map.get(num.charAt(left)).equals(num.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
