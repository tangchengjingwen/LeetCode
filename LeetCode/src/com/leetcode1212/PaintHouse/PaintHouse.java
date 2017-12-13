package com.leetcode1212.PaintHouse;

//
//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
//
//Note:
//All costs are positive integers.

public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs != null && costs.length == 0)
			return 0;
		for (int i = 1; i < costs.length; i++) {
			//涂第一种颜色的话，上一个房子就不能涂第一种颜色，这样我们要在上一个房子的第二和第三个颜色的最小开销中找最小的那个加上
			costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
//		返回涂三种颜色中开销最小的那个
		return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
	}
}
