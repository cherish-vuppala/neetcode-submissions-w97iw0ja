class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        int[][] memo = new int[m+1][n+1];

        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        return solve(i, j, m, n, memo);
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
