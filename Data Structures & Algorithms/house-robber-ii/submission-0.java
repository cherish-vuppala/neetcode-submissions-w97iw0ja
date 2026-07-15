class Solution {
    public int rob(int[] nums) {
        var path = new boolean[nums.length];
        return Math.max(solve(0, nums, path), solve(1, nums, path));
    }

    public int solve(int i, int[] nums, boolean[] path) {
        if (i >= nums.length) return 0;
        if (path[0] && i == nums.length-1) return 0;
        path[i] = true;
        int pick = nums[i] + solve(i + 2, nums, path);
        int skip = solve(i + 1, nums, path);
        path[i] = false;
        return Math.max(pick, skip);
    }
}
