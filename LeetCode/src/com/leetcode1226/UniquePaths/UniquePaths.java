package com.leetcode1226.UniquePaths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author tangc
 *
 */
public class UniquePaths {
	//time:O(m*n) space:O(m*n)
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			res[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			res[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
	
	//time:O(m*n) apzce:O(n)
	public int uniquePaths2(int m, int n) {
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}
	
	//排列组合time:O(m) space:O(1)
	public int uniquePaths3(int m, int n) {
		int count = m + n - 2;
		int k = m - 1;
		double res = 1;
		for (int i = 1; i <=k; i++) {
			res = res * (count - k + i) / i;
		}
		return (int)res;   
	}
}
