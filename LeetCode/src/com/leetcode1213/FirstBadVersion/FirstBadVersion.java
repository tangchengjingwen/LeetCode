package com.leetcode1213.FirstBadVersion;

//		You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//		
//		Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//		
//		You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
/**
 * @author tangc
 *
 */
public class FirstBadVersion {

	// binary search
	public int firstBadVersion2(int n) {
		int left = 1, right = n;
		int mid;
		boolean result;
		while (left <= right) {
			mid = left + (right - left) / 2;
			result = isBadVersion(mid);
			if (result) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

//	public int firstBadVersion(int n) {
//		int low = 1;
//		int high = n;
//		int mid;
//		boolean value;
//		while (low <= high) {
//			mid = low + (high - low) / 2;
//			value = isBadVersion(mid);
//			if (value) { /* 为真发现错误版本 */
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//
//		}
//		return low;
//	}

	boolean isBadVersion(int version) {
		return true;
	}
}
