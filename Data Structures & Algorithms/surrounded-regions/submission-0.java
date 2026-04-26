class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        // 1. Mark unsurroundable 'O's (those connected to borders)
        // Check first and last rows
        for (int c = 0; c < cols; c++) {
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }
        // Check first and last columns
        for (int r = 1; r < rows - 1; r++) { 
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }

        // 2. Process the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // Surrounded
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'; // Unsurroundable, restore it
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
            board[r][c] != 'O') {
            return;
        }

        // Temporarily mark as 'T' (for Temporary/Treated)
        board[r][c] = 'T';
        
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}