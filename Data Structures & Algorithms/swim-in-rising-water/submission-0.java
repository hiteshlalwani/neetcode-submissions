class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // dist[i][j] stores the minimum "max-elevation" to reach cell (i, j)
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // PriorityQueue stores {row, col, time}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // Initialize with the starting cell's elevation
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], t = cur[2];
            
            if (r == n - 1 && c == n - 1) return t;
            if (t > dist[r][c]) continue;
            
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    // The time to reach the neighbor is the MAX of current time 
                    // and the neighbor's elevation
                    int newTime = Math.max(t, grid[nr][nc]);
                    
                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.offer(new int[]{nr, nc, newTime});
                    }
                }
            }
        }
        return 0;
    }
}