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
        if (intervals.isEmpty()) return true;
        
        Collections.sort(intervals, 
        (a, b) -> a.start - b.start == 0 ? 
        a.end - b.end : a.start - b.start);

        var current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            var next = intervals.get(i);
            if (next.start < current.end) {
                return false;
            }
            current = next;
        }

        return true;
    }
}
