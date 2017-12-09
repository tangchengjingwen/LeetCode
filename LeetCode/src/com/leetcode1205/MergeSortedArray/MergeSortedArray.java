package com.leetcode1205.MergeSortedArray;

import java.util.Arrays;

//
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
//

public class MergeSortedArray {
	// 要从后往前排
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j])
				//nums1[index--]的意思为先将nums1[index] = nums1[i]然后index--， i--
				nums1[index--] = nums1[i--];
			else
				nums1[index--] = nums2[j--];
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}
	public static void main(String[] args) { 
		int[] nums1 = new int[15];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		nums1[3] = 7;
		nums1[4] = 9;
		int m = 5;
		int[] nums2 = {2,4,6,8}; int n = 4;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
		
	}
}
