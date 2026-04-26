class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Start DFS from top/bottom rows (Pacific/Atlantic)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, heights[0][c], pacific);
            dfs(heights, rows - 1, c, heights[rows - 1][c], atlantic);
        }

        // 2. Start DFS from left/right columns (Pacific/Atlantic)
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, heights[r][0], pacific);
            dfs(heights, r, cols - 1, heights[r][cols - 1], atlantic);
        }

        // 3. Find cells reachable by both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] visited) {
        // Boundary check, visited check, and height check (must be >= to flow backwards)
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || 
            visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;
        
        dfs(heights, r + 1, c, heights[r][c], visited);
        dfs(heights, r - 1, c, heights[r][c], visited);
        dfs(heights, r, c + 1, heights[r][c], visited);
        dfs(heights, r, c - 1, heights[r][c], visited);
    }
}