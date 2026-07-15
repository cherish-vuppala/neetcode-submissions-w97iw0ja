class Solution {
    public int rob(int[] nums) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum1 += nums[i];
        }

        for (int i = 1; i < nums.length; i += 2) {
            sum2 += nums[i];
        }

        return Math.max(sum1, sum2);
    }
}
