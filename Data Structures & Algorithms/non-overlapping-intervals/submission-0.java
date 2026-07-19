class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,
        (a,b) -> (a[0] - b[0] == 0) ? a[1] - b[1] : a[0] - b[0]);
        
        //System.out.println(Arrays.deepToString(intervals));

        int n = intervals.length;
        int[] current = intervals[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            int [] next = intervals[i];
            if (next[0] < current[1]) {
                count++;
            } else {
                current = next;
            }
        }

        return count;
    }
}
