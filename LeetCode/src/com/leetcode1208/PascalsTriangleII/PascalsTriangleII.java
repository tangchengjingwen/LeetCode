package com.leetcode1208.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?
public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
//		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (rowIndex<0) return null;
		rowIndex++;
		ArrayList<Integer> last = new ArrayList<Integer>();
		last.add(1);
//		list.add(last);
		
		for(int i = 1; i < rowIndex; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			for(int j = 1; j < i; j++) {
				tmp.add(last.get(j) + last.get(j-1));
			}
			tmp.add(1);
//			list.add(tmp);
			last = tmp;
		}
		return last;
	}
	
	public static void main(String[] args) {
		int num = 3;
		System.out.println(getRow(num));
	}
}
