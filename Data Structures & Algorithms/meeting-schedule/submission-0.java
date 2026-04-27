/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return true;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        return true;
    }
}
