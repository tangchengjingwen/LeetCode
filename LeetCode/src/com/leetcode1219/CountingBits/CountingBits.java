package com.leetcode1219.CountingBits;

//		
//		Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
//		
//		Example:
//		For num = 5 you should return [0,1,1,2,1,2].  0: 0000    1:0001    2: 0010    3: 0010          4:0100       5:0101
//		x =x & (x-1)      x1 = 1 & 0 = 0   1     x2 = 2&1 = 0   x5  = 5&4 = 0100 2
//		Follow up:
//		
//		It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
//		Space complexity should be O(n).
//		Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

public class CountingBits {
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			ans[i] = count(i);
		}
		return ans;
	}

	private int count(int x) {
		int cou;
		for (cou = 0; x != 0; cou++) {
			x = x & (x - 1);
		}
		return cou;
	}
}
