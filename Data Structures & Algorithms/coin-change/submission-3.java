class Solution {
    static final int  INF = 1_000_000;
    public int coinChange(int[] coins, int amount) {
        return solve(coins, amount, 0);
    }

    public int solve(int[] coins, int amount, int i) {
        if (i == coins.length) return INF;

        if (amount == 0) return 0;
        int pick = INF;

        if (coins[i] <= amount) {
            pick = 1 + solve(coins, amount - coins[i], i);
        }
        int skip = solve(coins, amount, i + 1);

        return Math.min(pick, skip);
    }
}
