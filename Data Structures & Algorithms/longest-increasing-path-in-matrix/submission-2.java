class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // 1. Calculate In-degrees
        // In-degree = how many neighbors are strictly SMALLER than the current cell
        int[][] inDegree = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] < matrix[r][c]) {
                        inDegree[r][c]++;
                    }
                }
            }
        }

        // 2. Add all "Valleys" (in-degree 0) to the Queue
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (inDegree[r][c] == 0) queue.offer(new int[]{r, c});
            }
        }

        // 3. BFS - Peel layers starting from the smallest numbers
        int levels = 0;
        while (!queue.isEmpty()) {
            levels++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0], nc = curr[1] + dir[1];
                    // Look at larger neighbors to "climb" the path
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[curr[0]][curr[1]]) {
                        inDegree[nr][nc]--;
                        if (inDegree[nr][nc] == 0) queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return levels;
    }
}