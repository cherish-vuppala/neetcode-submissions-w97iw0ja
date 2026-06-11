class Solution {
    public int numDecodings(String s) {
        int next1 = 1;
        int next2 = 0;
        int n = s.length();

        for (int i = n-1; i >= 0; i--) {
            int curr = 0;
            
            if (s.charAt(i) != '0') {
                curr = 0;
            
                curr += next1;
                if (i + 1 < s.length()) {
                    int two = Integer.parseInt(s.substring(i, i + 2));
                    if (two >= 10 && two <= 26)
                        curr += next2;
                }
            }

            next2 = next1;
            next1 = curr;
        } 

        return next1;
    }
}
