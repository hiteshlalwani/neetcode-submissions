class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    traverseIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverseIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] != '1' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (i+1 < grid.length) traverseIsland(grid, i+1, j, visited);
        if (j+1 < grid[0].length) traverseIsland(grid, i, j+1, visited);
        if (i-1 >= 0) traverseIsland(grid, i-1, j, visited);
        if (j-1 >= 0) traverseIsland(grid, i, j-1, visited);
    }
}
