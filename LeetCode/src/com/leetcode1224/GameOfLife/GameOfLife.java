package com.leetcode1224.GameOfLife;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as
 * Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population. Any live cell with two or three live neighbors lives on to
 * the next generation. Any live cell with more than three live neighbors dies,
 * as if by over-population.. Any dead cell with exactly three live neighbors
 * becomes a live cell, as if by reproduction. Write a function to compute the
 * next state (after one update) of the board given its current state.
 * 
 * @author tangc
 *time:O(m*n)   space:O(1)
 */
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) return;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = countNeighbor(board, i, j);
				if (board[i][j] == 1) {
					if (count == 2 || count == 3) {
						board[i][j] += 2; //满足条件，下一次为存活
					}
				} else if (count==3) {
					board[i][j] +=2;
				}
			}
		}
		//整体右移一位得到答案
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] >>1;
			}
		}
	}
	
	private int countNeighbor(int[][] board, int i, int j) {
		int count = 0;
		//保证不会越界
		for (int row = Math.max(0, i-1); row <= Math.min(i+1, board.length-1); row++) {
			for (int col = Math.max(0, j-1); col <=Math.min(j+1, board[0].length-1); col++) {
				if (row == i && col == j) continue;//跳过自己
				if ((board[row][col] & 1)==1) count++;//判断当前是否为1
			}
		}
		return count;
	}
}
