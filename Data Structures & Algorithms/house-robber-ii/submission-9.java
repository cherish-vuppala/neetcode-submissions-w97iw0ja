class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(
            solve(nums, 0, n-2),
            solve(nums, 1, n-1));
    }

    public int solve(int[] nums, int start, int end) {
        if (start > end) return 0;
        int n = nums.length;

        int[] dp = new int[end + 1];
        dp[start] = 0;
        dp[start + 1] = nums[start];
        

        for (int i = start + 2; i < end + 1; i++) {
            int pick = dp[i - 2] + nums[i-1];
            int skip = dp[i - 1];
            dp[i] = Math.max(pick, skip);
        }

        return dp[end];
    }
}
