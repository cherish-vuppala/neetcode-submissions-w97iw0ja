class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, i, j, 0, word, visited))
                    return true;
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int row, int col, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[row].length) return false;
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;

        // choose
        visited[row][col] = true;

        // explore all 4 directions
        for (int k = 0; k < 4; k++) {
            if (backtrack(board, row + dr[k], col + dc[k], index + 1, word, visited))
                return true;
        }

        // unchoose
        visited[row][col] = false;

        return false;
    }
}
