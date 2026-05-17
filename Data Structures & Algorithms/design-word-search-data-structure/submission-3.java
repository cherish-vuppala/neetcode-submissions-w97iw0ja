class WordDictionary {

    private class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        // Constructor
        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        // Getter for children
        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        // Setter for children
        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        // Getter for isEndOfWord
        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        // Setter for isEndOfWord
        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var curr = root;
        for (char ch: word.toCharArray()) {
            curr = curr.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        curr.setEndOfWord(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode currNode) {
        // path does not exist
        if (currNode == null)
            return false;
        
         // processed whole string 
        if (index == word.length()) {
            return currNode.isEndOfWord();
        }

        var ch = word.charAt(index);

        // processing wild character
        if (ch == '.') {
            for (var node: currNode.getChildren().values()) {
                if (dfs(word, index + 1, node)) {
                    return true;
                }
            }

            return false;
        }

        return dfs(word, index + 1, currNode.getChildren().get(ch));
        
        
    }
}
