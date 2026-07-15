class Solution {
    public int rob(int[] nums) {
      // at each element I have two choices
      //  pick and skip
      // choice 1 is to pick and choice 2 is to skip
      // to avoid picking adjacent elements i'll hop with i + 2 if I pick
      // and i + 1 if I skip
      // return buid it bottom up and return the answer
      int[] memo = new int[nums.length];
      Arrays.fill(memo, -1);
      return solve(0, nums, memo);

    }

    public int solve(int i, int[] nums, int[] memo) {
        if (i >= nums.length) return 0; // nothing to rob

        // if already computed return
        if (memo[i] != -1) return memo[i];

        int pick = nums[i] + solve(i+2, nums);
        int skip = solve(i+1, nums);
         
        return memo[i] = Math.max(skip, pick);
    }
}
