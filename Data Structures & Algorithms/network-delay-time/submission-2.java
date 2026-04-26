class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (n <= 0 || k < 1 || k > n || times == null || times.length == 0) return 0;
        List<int[]>[] adj = new ArrayList[n+1];
        for (int u = 1; u <= n; ++u) {
            adj[u] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int weight = time[2];
            adj[u].add(new int[]{v, weight});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
                
        // For Dijkstra algo - store {u, dist[u]} and order by dist[u] to choose next minimum reachable
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));   // sort by min distance
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            // Standard Dijkstra pruning: if we found a better way already, skip this stale entry
            if (d > dist[u]) continue;

            for (int[] nextVertData : adj[u]) {
                int v = nextVertData[0];
                int w = nextVertData[1];
                
                // ONLY push to queue if we found a strictly better path
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }

        // Final check: find the max distance among all reachable nodes
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
