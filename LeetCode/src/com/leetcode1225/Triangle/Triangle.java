package com.leetcode1225.Triangle;

import java.util.List;

/**
				 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
				
				For example, given the following triangle
				[
				     [2],
				    [3,4],
				   [6,5,7],
				  [4,1,8,3]
				]
				The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author tangc
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[] res = new int[triangle.size() + 1];
    	for (int i = triangle.size() - 1; i >= 0; i--) {
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
    		}
    	}
    	return res[0];
    }
}
