class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;
        int prevIndex = -1;

        for (int i = n-1; i >= 0; i--) {
            int skip = dp[i + 1];
            int pick = 0;
            if (prevIndex == -1 || nums[prevIndex] > nums[i]) {
                pick = 1 + dp[i + 1];
            }
            
            dp[i] = Math.max(pick, skip);
            prevIndex = i;
        }

        return dp[0];
    }
}
