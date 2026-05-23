class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        return !detectCycle(adj);
    }

    public boolean detectCycle(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        boolean[] path = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {

            if (!visited[i]) {

                if (dfs(i, graph, visited, path))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(int src,
                       List<List<Integer>> graph,
                       boolean[] visited,
                       boolean[] path) {

        // already in current recursion stack
        if (path[src])
            return true;

        // already processed safely
        if (visited[src])
            return false;

        visited[src] = true;
        path[src] = true;

        for (int neighbor : graph.get(src)) {

            if (dfs(neighbor, graph, visited, path))
                return true;
        }

        // backtracking step
        path[src] = false;

        return false;
    }
}