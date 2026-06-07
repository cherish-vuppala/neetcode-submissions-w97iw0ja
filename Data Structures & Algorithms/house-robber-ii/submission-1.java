class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robRange(0, n-2, nums), 
                        robRange(1, n-1, nums));
    }

    public int robRange(int low, int high, int[] nums) {
        int[] dp = new int[high + 3];

        for (int i = high; i >= low; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }

        return dp[low];
    }
}
