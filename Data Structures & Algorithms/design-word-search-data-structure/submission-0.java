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
            curr = curr.getChildren().computeIfAbsent('.', c -> new TrieNode());
            curr = curr.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        curr.setEndOfWord(true);
    }

    public boolean search(String word) {
        var curr = root;
        for (char ch: word.toCharArray()) {
            curr =  curr.getChildren().get(ch);
            if (curr == null) {
                return false;
            }
        }
        return curr.isEndOfWord();
    }
}
