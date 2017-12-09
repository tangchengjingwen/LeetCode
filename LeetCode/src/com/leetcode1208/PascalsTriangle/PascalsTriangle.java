package com.leetcode1208.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

//
//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows==0) return list;
		ArrayList<Integer> last = new ArrayList<Integer>();
		last.add(1);
		list.add(last);
		
		for(int i = 1; i < numRows; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			for(int j = 1; j < i; j++) {
				tmp.add(last.get(j) + last.get(j-1));
			}
			tmp.add(1);
			list.add(tmp);
			last = tmp;
		}
		return list;
		
	}
	public static void main(String[] args) {
		int num = 5;
		System.out.println(generate(num));
	}
}
