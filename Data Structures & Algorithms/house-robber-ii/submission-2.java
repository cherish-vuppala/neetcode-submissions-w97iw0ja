class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(
            solve(nums, 0, n-2),
            solve(nums, 1, n-1));
    }

    public int solve(int[] nums, int start, int end) {
        
        int[] dp = new int[end + 2];
        

        for (int i = start; i <= end; i++) {
            int pick = dp[i - 2] + nums[i-1];
            int skip = dp[i - 1];
            dp[i] = Math.max(pick, skip);
        }

        return dp[end];
    }
}
