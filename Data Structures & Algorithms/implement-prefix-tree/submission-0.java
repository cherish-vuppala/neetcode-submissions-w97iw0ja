class PrefixTree {

    private TrieNode root;

    private class TrieNode {

        private HashMap<Character, TrieNode> children;
        private boolean isEndOfWord;

        // Constructor
        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        // Getter for children
        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        // Setter for children
        public void setChildren(HashMap<Character, TrieNode> children) {
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

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c-> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null)
                return false;
        }
        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch: prefix.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null) {
                return false;
            }
        }

        return true;
    }
}
