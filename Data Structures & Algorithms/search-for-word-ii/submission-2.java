class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, 1, -1};

    private List<String> result = new ArrayList<>();
    

    public List<String> findWords(char[][] board, String[] words) {
        var sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (String word: words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    backtrack(board, i, j, 0, visited, sb, word);
                }
            }
        }

        return result;
    }

    public void 
    backtrack (char[][] board, int row, int col, int index, 
               boolean[][] visited, StringBuilder sb, String word) {
        if (index == word.length()) {
            result.add(sb.toString());
            sb.setLength(0);
            return;
        }

        // pruning
        if (row < 0 || row >= board.length) return;
        if (col < 0 || col >= board[0].length) return;
        if (visited[row][col]) return;
        if (board[row][col] != word.charAt(index)) return;

        // choosing
        visited[row][col] = true;
        sb.append(board[row][col]);

        for (int i = 0; i < 4; i++) {
            backtrack(board, row + dr[i], col + dc[i], index + 1, visited, sb, word);
        }

        // unchoosing
        visited[row][col] = false;
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
    }
}
