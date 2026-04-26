class Solution {
    private final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        int ROWS = grid.length, COLS = grid[0].length;
        
        Deque<int[]> q = new ArrayDeque<>();
        
        int fresh = 0;
        
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] dir : this.dirs) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < ROWS && newCol < COLS && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return (fresh == 0) ? time : -1;
    }
}
