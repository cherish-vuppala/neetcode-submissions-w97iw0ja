class Solution {
    List<String> result = new ArrayList<>();
    TrieNode root = new TrieNode();

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

   private class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;
        private String word;

        TrieNode () {
            children = new HashMap<>();
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

        // Getter for word
        public String getWord() {
            return word;
        }

        // Setter for word
        public void setWord(String word) {
            this.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int row, int col, TrieNode node) {
        

         // pruning
        if (row < 0 || row >= board.length) return;
        if (col < 0 || col >= board[0].length) return;
        if (board[row][col] == '#') return;


        char ch = board[row][col];

        // move in Trie
        var next = node.getChildren().get(ch);

        if (next == null) {
            return;
        }

        if (next.isEndOfWord()) {
            result.add(next.getWord());
            // avoid duplicates
            next.setWord(null);
            next.setEndOfWord(false);
        }

        // choosing
        board[row][col] = '#';

        for (int i = 0; i < 4; i++) {
            dfs(board, row + dr[i], col + dc[i], next);
        }

        // unchoosing
        board[row][col] = ch;
    }

    public TrieNode buildTrie(String[] words) {

        for (String word: words) {
            insert(word);
        }

        return root;
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }

        current.setEndOfWord(true);
        current.setWord(word);
    }
}
