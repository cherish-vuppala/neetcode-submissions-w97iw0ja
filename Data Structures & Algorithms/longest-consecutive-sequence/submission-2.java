class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int max = 0;

        for (int num: nums) {
            set.add(num);
        }

        for (int num: set) {
            int prev = num - 1;
            int count = 0;
            // found start
            if (!set.contains(prev)) {
                int next = num;
                while (set.contains(next)) {
                    next++;
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        return max;

        
    }
}
