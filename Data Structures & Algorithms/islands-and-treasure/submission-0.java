class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // 1. Add all treasure chests to the queue first
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        // 2. Directions for Up, Down, Left, Right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 3. Standard BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dr : directions) {
                int nr = r + dr[0];
                int nc = c + dr[1];

                // Only visit if it's within bounds and is a Land cell (INF)
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && 
                    grid[nr][nc] == Integer.MAX_VALUE) {
                    
                    // The distance to this cell is distance of current + 1
                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}