class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Set<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int target = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            int start = i + 1, end = nums.length-1;
            Set<Integer> triplet = new HashSet<>();
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    start++;
                    end--;
                    set.add(triplet);
                } else if (sum > target) end--;
                else start++;
            }
            set.add(triplet);
        }

        for (Set<Integer> triplet: set) {
            result.add(new ArrayList<>(triplet));
        }

        return result;
    }
}
