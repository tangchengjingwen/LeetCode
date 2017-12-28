package com.leetcode1227.TrappingRainWater;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author tangc
 *time:O(n) space:O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
    	int left = 0; 
    	int right = height.length - 1;
    	int res = 0;
    	int leftMax = 0;
    	int rightMax = 0;
    	while (left < right) {
    		if (height[left] < height[right]) {
    			leftMax = Math.max(height[left], leftMax);
    			res += leftMax - height[left];
    			left++;
    		} else {
    			rightMax = Math.max(height[right], rightMax);
    			res += rightMax - height[right];
    			right--;
    		}
    	}
    	return res;
    }
}
