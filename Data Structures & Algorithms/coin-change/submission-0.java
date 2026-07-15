class Solution {
    public int coinChange(int[] coins, int amount) {
       
    }

    public int solve(int[] coins, int amount, int i) {
        
        if (amount == 0) return 0;
        

        if (i >= coins.length) return -1;

        int pick = solve(coins, amount - coins[i], i);
        int skip = solve(coins, amount, i+1);

        return 1 + Math.min(skip, pick);
    }
}
