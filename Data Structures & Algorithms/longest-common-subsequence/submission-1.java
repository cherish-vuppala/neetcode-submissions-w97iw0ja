class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }

    public int lcs(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        int len = 0;
        int len1 = 0, len2 = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            len = 1 + lcs(s1, s2, i+1, j+1);
        } else {
            len1 = lcs(s1, s2, i+1, j);
            len2 = lcs(s1, s2, i, j+1);
        }

        return Math.max(len, Math.max(len1, len2));
    }
}
