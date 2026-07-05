class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m + 1][n + 1];
       dp[m-1][n-1] = 1;

       for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    dp[i][j] = 1;
                } else {
                    int right = dp[i][j + 1];
                    int down = dp[i + 1][j];
                    dp[i][j] = right + down;
                }
            }
       }

       return dp[0][0];
    }

    private int solve(int i, int j, int m, int n, int[][] memo) {
        if (i == m || j == n) return 0;
        
        // reached goal
        if (i == m-1 && j == n-1) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        int right = solve(i + 1, j, m, n, memo);
        int down = solve(i, j + 1, m, n, memo);

        return memo[i][j] = right + down;
    }

}
