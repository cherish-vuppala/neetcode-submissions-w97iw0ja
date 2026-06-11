class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[amount + 1][coins.length];
        for (int[] arr: memo) Arrays.fill(arr, -1);
        return solve(coins, amount, 0, memo);
    }

    public int solve(int[] coins, int amount, int i, int[][] memo) {
        int pick = -1, skip = 0;
        if (amount == 0) return 0;
        

        if (i >= coins.length) return -1;

        if (memo[amount][i] != -1) return memo[amount][i];

        // only proceed i amount is still grater than the current coin
        if (amount >= coins[i]) {
            int sub = solve(coins, amount - coins[i], i, memo);
            if (sub != -1)
                pick = sub + 1;
        }
            

        skip = solve(coins, amount, i + 1, memo);

        if (pick == -1 && skip == -1) return -1;
        if (pick == -1) return skip;
        if (skip == -1) return pick;

        return memo[amount][i] = Math.min(pick, skip);
    }
}
