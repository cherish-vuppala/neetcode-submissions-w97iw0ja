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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        int i = 0;
        for (var interval: intervals) {
            starts[i] = interval.start;
            ends[i] = interval.end;
            i++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0, maxRooms = 0;
        int s = 0, e = 0;
        while (s < n) {
            if (starts[s] < ends[e]) {
                rooms++;
                s++;
            } else {
                rooms--;
                e++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }
}
