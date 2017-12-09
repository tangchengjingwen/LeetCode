package com.leetcode1208.BestTimetoBuyandSellStock;




//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//

public class BestTimetoBuyandSellStock2 {
	
	public static int maxProfit(int[] prices) {
		int maxprofit = 0;
		for(int i = 1; i < prices.length; i ++) {
			if (prices[i] > prices[i-1]) 
				maxprofit = maxprofit + prices[i] - prices[i-1];
		}
		return maxprofit;
	}
	
	public static void main(String[] args) {
		int[] prices = {4,7,8,2,8};
		System.out.println(maxProfit(prices));
		System.out.println();
	}
}
