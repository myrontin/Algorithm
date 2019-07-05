package mergeintervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;
		List<Interval> result = new ArrayList<>();
		intervals.sort(Solution.MergeComparator);
		// intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start, end));
		return result;
	}

	public static Comparator<Interval> MergeComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start)
				return -1;
			if (i1.start > i2.start)
				return 1;
			return 0;
		}

	};
}
