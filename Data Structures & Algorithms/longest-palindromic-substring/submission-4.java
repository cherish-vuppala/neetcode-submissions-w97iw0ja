class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
       
        int n = s.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            int oddLen = expand(s, i, i);
            if (oddLen > maxLen) {
                start = i - oddLen/2;
                maxLen = oddLen;
            }

            int evenLen = expand(s, i, i+1);
            if (evenLen > maxLen) {
                start = i - evenLen/2 - 1;
                evenLen = maxLen;
            }
        }

        return s.substring(start, start+maxLen);
    }

    public int expand(String str, int s, int e) {
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
        }

        return e - s - 1;
    }
}
