class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int max = 0;

        for (int num: nums) {
            set.add(num);
        }

        for (int num: set) {
            int start = num + 1;
            int count = 1;
            while (set.contains(start) && !visited.contains(start)) {
                set.add(start);
                visited.add(start);
                start++;
                count++;
            }

            max = Math.max(max, count);
        }

        return max;

        
    }
}
