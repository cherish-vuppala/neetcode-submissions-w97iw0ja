class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        
        int left = 0, right = 0;
        Map<Character, Integer> need = new HashMap<>();

        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int formed = 0;
        int required = need.size();
        StringBuilder sb = new StringBuilder();

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            sb.append(c);

            if (need.containsKey(c) &&
                need.get(c).intValue() == window.get(c).intValue()) {
                    formed++;
            }

            System.out.println("c: " + c);
            System.out.println("need: " + need);
            System.out.println("window: " + window);
            System.out.println("formed: " + formed);
            System.out.println("left: " + left);
            System.out.println("right: " + right);
           // System.out.println("so far string traversed: " + sb);
            // shrink if we found all chars of t in the window
            while (left <= right && formed == required) {
                System.out.println("In shrink: ");
                if (right - left + 1 < minLen) {
                    System.out.println("In updating start...");
                    minLen = right - left + 1;
                    start = left;
                    System.out.println("updated start...");
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);

                System.out.println("left: " + left);
                System.out.println("leftChar: " + leftChar);
                System.out.println("minLen: " + minLen);
                System.out.println("start: " + start);
                System.out.println("window: " + window);
                

                if (need.containsKey(leftChar) && 
                    window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);

    }
}
