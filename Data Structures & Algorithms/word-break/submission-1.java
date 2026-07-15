class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        return solve(0, s, dictSet);
    }

    public boolean solve(int i, String s, Set<String> dictSet) {
        if (i >= s.length()) return true;

        for (int j = i; j < s.length(); j++) {
            var word = s.substring(i, j + 1);
            //System.out.println(word);
            if (dictSet.contains(word)) {
                //System.out.println(dictSet.contains(word));
                if (solve(j + 1, s, dictSet)) {
                    return true;
                }

            }
        }

        return false;
    }
}
