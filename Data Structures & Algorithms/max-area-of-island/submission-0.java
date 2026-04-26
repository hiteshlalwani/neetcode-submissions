class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j, visited));
                }
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] != 1 || visited[i][j]) return 0;
        int area = 1;
        visited[i][j] = true;
        if (i+1 < grid.length) {
            area += areaOfIsland(grid, i+1, j, visited);
        }
        if (j+1 < grid[0].length) {
            area += areaOfIsland(grid, i, j+1, visited);
        }
        if (i-1 >= 0) {
            area += areaOfIsland(grid, i-1, j, visited);
        }
        if (j-1 >= 0) {
            area += areaOfIsland(grid, i, j-1, visited);
        }
        return area;
    }
}
