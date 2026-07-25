class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
       
        int n = s.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            int oddLen = expand(s, i, i);
            if (oddLen > maxLen) {
                start = oddLen/ 2 - i;
                maxLen = oddLen;
            }

            int evenLen = expand(s, i, i+1);
            if (evenLen > maxLen) {
                start = evenLen / 2 - i -1;
                evenLen = maxLen;
            }
        }

        return s.substring(start, start+maxLen);
    }

    public int expand(String s, int s, int e) {
        while (s >= 0 && e < s.length() && s.charAt(s) == s.charAt(e)) {
            s--;
            e++;
        }

        return e - s - 1;
    }
}
