package com.leetcode1227.MedianOfTwoSortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author tangc
 *time:O(log(min(m,n)))
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
        	return findMedianSortedArrays(nums2, nums1);
        }
        
        int len = nums1.length + nums2.length;
        int cut1 = 0, cut2 = 0, cutL = 0, cutR = nums1.length;
        while (cut1 <=nums1.length) {
        	cut1 = cutL + (cutR-cutL)/2;
        	cut2 = len /2 - cut1;
        	double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
        	double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
        	double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
        	double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
        	if (L1 > R2) {
        		cutR = cut1 - 1;
        	} else if (L2 > R1) {
        		cutL = cut1 + 1;
        	} else {
        		if (len % 2 == 0) {
        			L1 = L1 > L2 ? L1 : L2;
        			R1 = R1 < R2 ? R1 : R2;
        			return (L1 + R1)/2;
        		} else {
        			R1 = (R1 < R2) ? R1 : R2;
        			return R1;
        		}
        	}
        }
        return -1; 
    }
}
