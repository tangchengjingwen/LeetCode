package com.leetcode1228.MaxPointsOnALine;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author tangc
 *
 */
public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		if (points.length <= 2) return points.length;
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int samePoint = 0;
			int sameXAxis = 1;//需要注意！！！
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					if (points[i].x == points[j].x && points[i].y == points[j].y ) {
						samePoint++;
					}
					if (points[i].x == points[j].x) {
						sameXAxis++;
						continue;
					}
					int numerator = points[i].y - points[j].y;
					int denominator = points[i].x - points[j].x;
					int gcd = gcd(numerator, denominator);
					String hashStr = (numerator / gcd) + "/" + (denominator / gcd);
					map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
					res = Math.max(res, map.get(hashStr) + samePoint);
				}
			}
			res = Math.max(res, sameXAxis);
		}
		return res;
	}

	private int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}