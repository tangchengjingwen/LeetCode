package com.leetcode1220.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//		Given a collection of intervals, merge all overlapping intervals.
//		
//		For example,
//		Given [1,3],[2,6],[8,10],[15,18],
//		return [1,6],[8,10],[15,18].

//time:O(nlogn) space:O(n)
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() <= 1) return intervals;
		Collections.sort(intervals, (a,b) -> a.start - b.start);
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> res = new ArrayList<>();
		for (Interval interval : intervals) {
			if(interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
}

class Interval {
	int start, end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

}
