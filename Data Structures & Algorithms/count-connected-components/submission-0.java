class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) return 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.components;
    }

    private static class UnionFind {
        int components;
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            this.components = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int u = 0; u < n; ++u) {
                parent[u] = u;
            }
        }

        public int find(int u) {
            int cur = u;
            while (parent[cur] != cur) {
                cur = parent[parent[cur]];
            }
            return parent[u] = cur;
        }

        public boolean union(int u, int v) {
            if (u == v) return false;
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return false;
            if (rank[pu] <= rank[pv]) {
                parent[pu] = pv;
                rank[pv]++;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
            this.components--;
            return true;
        }
    }
}
