class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> dictSet = new HashSet<>(wordDict);
        return solve(0, s, dictSet);
    }

    public boolean solve(int i, String s, Set<String> dictSet, Boolean[] memo) {
        if (i >= s.length()) return true;
        if (memo[i] != null) return memo[i];

        for (int j = i; j < s.length(); j++) {
            if (dictSet.contains(s.substring(i, j + 1))) {
                //System.out.println(dictSet.contains(word));
                if (solve(j + 1, s, dictSet)) {
                    return memo[i] = true;
                }
            }
        }

        return memo[i] = false;
    }
}
