package com.leetcode1219.NumberOfIslands;

//			Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//			
//			Example 1:
//			
//			11110
//			11010
//			11000
//			00000
//			Answer: 1
//			
//			Example 2:
//			
//			11000
//			11000
//			00100
//			00011
//			Answer: 3

//time:O(mn)    dfs
public class NumberOfIslands {
	public int numsIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		int ans = 0;
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (grid[y][x] == '1') {
					ans++;
					dfs(grid, x, y, n, m);
				}
			}
		}
		return ans;
	}

	private void dfs(char[][] grid, int x, int y, int n, int m) {
		if (x < 0 || y < 0 || x >= n || y >= m || grid[y][x] == '0') {
			return;
		}
		grid[y][x] = '0';
		dfs(grid, x + 1, y, n, m);
		dfs(grid, x - 1, y, n, m);
		dfs(grid, x, y + 1, n, m);
		dfs(grid, x, y - 1, n, m);
	}
}
