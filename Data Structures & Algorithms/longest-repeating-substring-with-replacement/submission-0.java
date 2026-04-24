class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int[] freq = new int[26];
        int maxLen = 0, maxFreq = 0;

        for (end = 0; end < s.length(); end++) {
            freq[(s.charAt(end) - 'A')]++;
            maxFreq = Math.max(maxFreq, freq[(s.charAt(end) - 'A')]);

            int windowSize = end - start + 1;

            if (windowSize - maxFreq > k) {
                freq[(s.charAt(start) - 'A')]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
