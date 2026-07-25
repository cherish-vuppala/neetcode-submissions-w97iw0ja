class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            count += odd + even;
        }

        return count;
    }

    public int expand(String str, int s, int e) {
        int count = 0;
        
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
            count++;
        }

        return count;
    }
}
