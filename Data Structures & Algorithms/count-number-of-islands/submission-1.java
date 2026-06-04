class Solution {
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0;i < grid.length; i++) {
            for (int j=0; j < grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid, grid.length, grid[0].length);
                    count++;
                }
            }

        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows||j>= cols) return;
        if(grid[i][j] == '0') return;

        grid[i][j] = '0';

        for (var dir: dirs) {
            dfs(i + dir[0], j + dir[1], grid, rows, cols);
        }
    }
}
