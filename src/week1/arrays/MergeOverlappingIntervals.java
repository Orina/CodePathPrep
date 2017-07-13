package week1.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 *
 * Created by Elmira Andreeva on 7/12/17.
 */
public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return result;

        // sort intervals by their "start" point
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) return -1;
                else if (i1.start > i2.start) return 1;
                else if (i1.end < i2.end) return -1;
                else if (i1.end > i2.end) return 1;
                else return 0;
            }
        });

        int N = intervals.size();
        Interval lastMerged = intervals.get(0);

        for (int i = 1; i < N; i++) {
            Interval cur = intervals.get(i);
            if (lastMerged.end < cur.start) {
                //add already merged interval to the result list
                result.add(lastMerged);
                //set current interval to next merge
                lastMerged = cur;
            } else {
                //merge intervals: only update the "end" point as the intervals are already sorted by "start" point
                lastMerged.end = Math.max(lastMerged.end, cur.end);
            }
        }

        result.add(lastMerged);
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
