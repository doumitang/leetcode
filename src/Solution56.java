import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution56 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // Runtime: 140 ms, faster than 5.13% of Java online submissions for Merge Intervals.
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> intervalList = new ArrayList<>();
        int i = 0, j = 1;
        while (i < intervals.size()) {
            while (j < intervals.size()) {
                System.out.println("" + i + " " + j);
                Interval interval1 = intervals.get(i);
                Interval interval2 = intervals.get(j);
                if (i == j || interval2.start > interval2.end) {
                    j++;
                    continue;
                }
                if (interval2.start >= interval1.start && interval2.start <= interval1.end || interval1.start >= interval2.start && interval1.start <= interval2.end) {
                    interval1.start = Math.min(interval1.start, interval2.start);
                    interval1.end = Math.max(interval1.end, interval2.end);
                    interval2.end = interval2.start - 1; // 无效化j所在的区间
                    continue;
                }
                j++;
            }
            i++;
            j = 0;
        }
        for (Interval interval:intervals) {
            if (interval.start <= interval.end) intervalList.add(interval);
        }
        return intervalList;
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(1, 10));
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 3));
        intervals2.add(new Interval(2, 6));
        intervals2.add(new Interval(8, 10));
        intervals2.add(new Interval(15, 8));
        System.out.println(solution56.merge(intervals2));
    }
}