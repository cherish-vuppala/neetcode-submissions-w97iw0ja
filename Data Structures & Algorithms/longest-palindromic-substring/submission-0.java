class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            var odd = expand(i, i, s);
            if (odd > maxLen) {
                maxLen = odd;
                start = i - odd / 2;
            }
            var even = expand(i, i + 1, s);

            if (even > maxLen) {
                maxLen = even;
                start = i - (even / 2 - 1);
            }
        }

        return s.substring(start, start+maxLen);
    }

    public int expand(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
