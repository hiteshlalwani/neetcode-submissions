class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0) return false;
        if (edges == null) return n==0;
        // if (edges.length != n-1) return false;
        
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int u = 0; u < n; ++u) {
            adj[u] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean cycle = hasCycle(adj, 0, -1, visited);
        boolean allVisited = true;
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i]) {
                allVisited = false;
                break;
            }
        }
        return !cycle && allVisited;
    }

    private boolean hasCycle(List<Integer>[] adj, int u, int p, boolean[] visited) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (v == p) continue;
            if (visited[v] || hasCycle(adj, v, u, visited)) return true;
        }
        return false;
    }
}
