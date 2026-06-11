class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[n] = 1;

        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            int ways = dp[i + 1];
            if (i + 1 < n) {
                int num = Integer.parseInt(s.substring(i, i+2));
                if (num >= 10 && num <= 26) {
                    ways += dp[i + 2];
                }
            }

            dp[i] = ways;
        }

        return dp[0];
    }
}
