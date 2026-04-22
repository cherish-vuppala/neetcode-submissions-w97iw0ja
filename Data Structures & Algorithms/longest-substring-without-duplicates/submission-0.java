


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();

        int start = 0, end = 0;
        int len = 0;

        while (end < s.length()) {

            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(s.charAt(end));
            len = Math.max(len, end-start + 1);
            end++;
        }

        return len;

        
    }
}
