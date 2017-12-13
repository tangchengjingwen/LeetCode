package com.leetcode1212.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

//

//
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//
//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return false.
//

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			for (int j = i + 1; j < intervals.length; j++) {
				if (overloap(intervals[i], intervals[j]))
					return false;
			}
		}
		return true;
	}

	private boolean overloap(Interval i1, Interval i2) {
		return ((i1.start >= i2.start && i1.start < i2.end) || (i2.start >= i1.start && i2.start < i1.end));
	}

	// ====================================================
	// sorting
	public boolean canAttendMeetings2(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		}
		return true;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
