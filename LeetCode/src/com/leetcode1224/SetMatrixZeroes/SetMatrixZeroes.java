package com.leetcode1224.SetMatrixZeroes;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author tangc time:O(m*n) space:O(1)
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0] == null)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row = false;
		boolean col = false;
		
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] ==0) {
				col = true;
				break;
			}
		}
		
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] ==0) {
				row = true;
				break;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					// 先把位于matrix[i][j] 的首行首列第一个设为0
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// 上面的循环已经走过第0行0列，所以这里跳过
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (row) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		if (col) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

	}
}
