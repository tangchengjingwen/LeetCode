package com.leetcode1226.GasStation;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author tangc
 *time:O(n) space:O(1)
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || cost.length ==0 || gas.length != cost.length) return -1;
		int total = 0, sum = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			total += (gas[i] - cost[i]);
			if (sum < 0) {
				sum = (gas[i] - cost[i]);
				start = i;
			} else {
				sum += (gas[i] - cost[i]);
			}
		}
		return total < 0 ? -1 : start;
	}
}	
