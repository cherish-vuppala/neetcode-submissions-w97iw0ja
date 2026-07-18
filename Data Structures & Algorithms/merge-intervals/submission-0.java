class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] newInterval = intervals[0];
        int i = 1;
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < n && intervals[i][0] > newInterval[1]) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][0]);
    }
}
