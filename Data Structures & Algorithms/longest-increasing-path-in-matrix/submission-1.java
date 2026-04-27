class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // 1. Calculate Out-degrees
        // Out-degree = how many neighbors are strictly GREATER than the current cell
        int[][] outDegree = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                        outDegree[r][c]++;
                    }
                }
            }
        }

        // 2. Add all "Peaks" (out-degree 0) to the Queue
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (outDegree[r][c] == 0) queue.offer(new int[]{r, c});
            }
        }

        // 3. BFS - Peel layers from the graph (like counting levels in a tree)
        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int pr = curr[0] - dir[0], pc = curr[1] - dir[1]; // Look at neighbors that could lead HERE
                    if (pr >= 0 && pr < rows && pc >= 0 && pc < cols && matrix[pr][pc] < matrix[curr[0]][curr[1]]) {
                        outDegree[pr][pc]--;
                        if (outDegree[pr][pc] == 0) queue.offer(new int[]{pr, pc});
                    }
                }
            }
        }
        return height;
    }
}