class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        int n = coins.length;

        for (int i = 1; i <= amount; i++) {
            dp[i][n] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = n-1; j >= 0; j--) {
                int pick = -1;
                if (coins[j] <= i) {
                    int sub = dp[i - coins[j]][j];
                    if (sub != -1) 
                        pick = sub + 1;
                    
                }

                int skip = dp[i][j + 1];

                if (pick == -1 && skip == -1) 
                    dp[i][j] = -1;
                else if (pick == -1) 
                    dp[i][j] = skip;
                else if (skip == -1)
                    dp[i][j] = pick;
                else 
                    dp[i][j] = Math.min(pick, skip);

            }
        }

        return dp[amount][0];
    }
}
