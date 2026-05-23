class Solution {
    public int countComponents(int n, int[][] edges) {
        var adj = buildAdjacencyList(edges, n);
        int count = 0;

        var visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v, visited, adj);
                count++;
            }

        }

        return count;
    }

    public List<List<Integer>> buildAdjacencyList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }

    public void dfs(int v, boolean[] visited, List<List<Integer>> adj) {
        visited[v] = true;

        for (var neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}
