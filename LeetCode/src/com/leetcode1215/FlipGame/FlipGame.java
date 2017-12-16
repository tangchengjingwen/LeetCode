package com.leetcode1215.FlipGame;

import java.util.ArrayList;
import java.util.List;

//	You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//	
//	Write a function to compute all possible states of the string after one valid move.
//	
//	For example, given s = "++++", after one move, it may become one of the following states:
//	
//	[
//	  "--++",
//	  "+--+",
//	  "++--"
//	]
//	If there is no valid move, return an empty list [].
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<>();
		char[] str = s.toCharArray();
		
		for(int i = 0; i < str.length - 1 ; i++) {
			if(str[i] == '+' && str[i+1] == '+') {
				str[i] = str[i+1] = '-';
				//将满足条件的结果添加到list里面去。
				list.add(String.valueOf(str));
				str[i] = str[i+1] = '+';		
			}
		}
		return list;
	}
}
