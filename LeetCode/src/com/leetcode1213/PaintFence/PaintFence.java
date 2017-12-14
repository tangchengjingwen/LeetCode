package com.leetcode1213.PaintFence;

//	
//	There is a fence with n posts, each post can be painted with one of the k colors.
//	
//	You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//	
//	Return the total number of ways you can paint the fence.
public class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0 || (k==1 && n > 2))
			return 0;
		
		int same = 0, diff = k, total = k;
		for(int i = 2; i <= n ;i++) {
			same = diff; 
			diff = total * (k-1);
			total = same + diff;
		}
		return total;
		
	}
}
