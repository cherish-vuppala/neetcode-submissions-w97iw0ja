class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return result;
        
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // traversing boundary cells
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, cols-1, atlantic);
        }

        
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, rows-1, c, atlantic);
        }

        // preparing result
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        // pruning for invalid cells
        ocean[r][c] = true;

        for (int[] d: dir) {
            // next row amnd col
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= heights.length) continue;
            if (nc < 0 || nc >= heights[0].length) continue;
            // Reverse flow : only go to cells that >= current height
            if (heights[nr][nc] < heights[r][c]) continue;
            // if visited skip
            if (ocean[nr][nc]) continue;

            dfs(heights, nr, nc, ocean);
        }

    }
}
