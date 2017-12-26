package com.leetcode1225.MinimumPathSum;


/**
			 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
			
			Note: You can only move either down or right at any point in time.
			
			Example 1:
			[[1,3,1],
			 [1,5,1],
			 [4,2,1]]
			Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * @author tangc
 *time:O(m*n)  space:O(1)
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
//    	直接在原矩阵中进行加
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (i == 0 && j != 0) grid[i][j] += grid[i][j-1];
    			if (i != 0 && j == 0) grid[i][j] += grid[i-1][j];
    			if (i != 0 && j != 0) {
    				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    			}
    		}
    	}
    	return grid[grid.length - 1][grid[0].length - 1];
    }	
}
