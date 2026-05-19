class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        //List<List<Integer>> adjencyList = build(grid);
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == '1'){
                 dfs(grid, i, j);
                 count++;
               }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {

        // pruning
        if (row < 0 || row >= grid.length) return ;
        if (col < 0 || col >= grid[0].length) return ;
        if (grid[row][col] == '0') return ;

        // mark as visited
        grid[row][col] = '0';

        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dr[i], col + dc[i]);
        }
    }

   /* public List<List<Integer>> build(char[][] grid) {
        List<List<Integer>> list = new ArrayList<>();

        for (var row: grid) {
            list.add(new ArrayList<>());
            for (int i = 0; i < row.length; i++) {
                list.get(i).add(0);
            }
        }
            

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    list.get(i).set(j, 1);
                    list.get(j).set(i, 1);
                }
            }
        }

        return list;
    }*/
}
