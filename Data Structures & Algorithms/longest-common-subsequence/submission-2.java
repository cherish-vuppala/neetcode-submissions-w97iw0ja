class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (var arr : memo) {
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, 0, 0, memo);
    }

    public int lcs(String s1, String s2, int i, int j, int[][] memo) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int len = 0;
        int len1 = 0, len2 = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            len = 1 + lcs(s1, s2, i+1, j+1, memo);
        } else {
            len1 = lcs(s1, s2, i+1, j, memo);
            len2 = lcs(s1, s2, i, j+1, memo);
        }

        return memo[i][j] = Math.max(len, Math.max(len1, len2));
    }
}
