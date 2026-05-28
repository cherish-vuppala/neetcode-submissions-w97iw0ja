class Solution {
    public String foreignDictionary(String[] words) {
      Map<Integer, Set<Integer>> adj = new HashMap<>();

      for (var w: words) {
        for (var c: w.toCharArray()) {
            adj.putIfAbsent((c - 'a'), new HashSet<Integer>());
        }
      }

      for (int i = 0; i < words.length-1; i++) {
        var s1 = words[i];
        var s2 = words[i + 1];

        int j = 0, len = Math.min(s1.length(), s2.length());
        // edge case: "abc" before "ab" is invalid
        if (s1.startsWith(s2) && s1.length() > s2.length()) return "";

        while (j < len) {
            if (s1.charAt(j) != s2.charAt(j)) {
                int v1 = s1.charAt(j) - 'a';
                int v2 = s2.charAt(j) - 'a';
                adj.get(v1).add(v2);
                break;
            }
            j++;
        }
      }

      return topoSort(adj);
    }

    public String topoSort(Map<Integer, Set<Integer>> adj) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> path = new HashSet<Integer>();
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (var node : adj.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycle(node, adj, visited, path, stack)) {
                    return "";
                } 
            } 
        }

        while (!stack.isEmpty()) {
            sb.append((char)(stack.pop() + 'a'));
        }

        return sb.toString();
    }

    public boolean hasCycle(int node, 
    Map<Integer, Set<Integer>> adj, 
    Set<Integer> visited, Set<Integer> path, Deque<Integer> stack) {

        visited.add(node);
        path.add(node);

        for (int neighbor: adj.get(node)) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, adj, visited, path, stack)) {
                    return true;
                }
            } else if (path.contains(neighbor)) {
                return true;
            }
        }

        path.remove(node);
        stack.push(node);

        return false;
    }
}
