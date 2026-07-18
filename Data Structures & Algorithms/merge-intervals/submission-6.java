class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            var next = intervals[i];
            if (next[0] <= current[1]) {
                current[0] = Math.min(next[0], current[0]);
                current[1] = Math.max(next[1], current[1]);
            } else {
                current = next; // form a new group
                result.add(current);
            }
        }

        return result.toArray(new int[0][0]);
    }
}
