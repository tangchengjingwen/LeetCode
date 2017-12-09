package com.leetcode1208.BestTimetoBuyandSellStock2;

//
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5
//
//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Example 2:
//Input: [7, 6, 4, 3, 1]
//Output: 0
//
//In this case, no transaction is done, i.e. max profit = 0.
public class BestTimetoBuyandSellStock {
	public static int maxProfit (int[] prices) {
		int maxprofit = 0;
		for(int i = 0; i < prices.length; i++) {
			for(int j = i+1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if(profit > maxprofit) 
					maxprofit = profit;
			}
		}
		return maxprofit;
	}
	
	public static int maxProfit2 (int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for(int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice)
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}
	
	public static void main(String[] args) {
		int[] prices = {7, 6, 4, 3, 1};
		int[] price = {7, 1, 5, 3, 6, 4};
		int maxProfit2 = maxProfit2(prices);
		System.out.println(maxProfit2);
		System.out.println(maxProfit2(price));
	}
}
