class Solution {
    public String minWindow(String s, String t) {
        int minLen = s.length();
        String minStr = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                    Map<Character, Integer> map = new HashMap<>();
                    String subStr = s.substring(i, j+1);
                    for (char c: subStr.toCharArray()) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                    }

                    System.out.println("substr: " + subStr);
                    System.out.println("map: " + map);

                    int len = subStr.length();
                    boolean flag = containsAllChars(subStr, t, map);

                    System.out.println("flag: " + flag);

                    if (flag && minLen >= len) {
                        minLen = len;
                        minStr = subStr;
                    }

                    System.out.println("minStr: " + minStr);

            }
        }

        return minStr;
    }

    private boolean containsAllChars(String str, String t, Map<Character, Integer> map) {

        for (char c: t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
