package com.leetcode1211.CountPrimes;

//
//Description:
//
//Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes {
	public int countPrimes(int n) {
		if (n < 2)
			return 0;

		boolean[] isPrime = new boolean[n];
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i]) {
				for (int j = i; j * i < n; j++) {
					isPrime[j * i] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!isPrime[i])
				count++;
		}
		return count;

	}
}
