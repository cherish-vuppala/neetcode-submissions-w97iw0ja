class Solution {
    public boolean validTree(int n, int[][] edges) {
        var adj = buildAdjacencyList(n, edges);
        var visited = new boolean[n];
        if (dfs(0, -1, visited, adj)) return false;
        for (var v: visited)
            if (!v) return false;
        if (edges.length == n-1)
            return true;
        return false;

    }

    public boolean dfs(int vertex, int parent, 
    boolean[] visited, List<List<Integer>> adj) {
        visited[vertex] = true;

        for (int neighbor: adj.get(vertex)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, vertex, visited, adj)) {
                    return true;
                } 
            } else if (neighbor != parent) return true;
        }

        return false;


    }

     public List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
