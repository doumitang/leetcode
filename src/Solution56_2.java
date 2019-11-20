import java.util.ArrayList;
import java.util.Comparator;
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
class Solution56_2 {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (Interval interval:intervals) {
            Interval last = null;
            if (!ans.isEmpty()) last = ans.get(ans.size() - 1);
            if (last == null || last.end < interval.start) {
                ans.add(interval);
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution56_2 solution56_2 = new Solution56_2();
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
        System.out.println(solution56_2.merge(intervals2));
    }
}