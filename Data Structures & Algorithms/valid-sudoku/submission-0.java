class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Set<Character> charSet = new HashSet<>();
        for (int idx = 0; idx < N; ++idx) {
            for (int j = 0; j < N; ++j) {
                if (board[idx][j] != '.' && !charSet.add(board[idx][j])) {
                    return false;
                }
            }
            charSet.clear();

            for (int i = 0; i < N; ++i) {
                if (board[i][idx] != '.' && !charSet.add(board[i][idx])) {
                    return false;
                }
            }
            charSet.clear();

            int rowOffset = (idx/3)*3;
            int colOffset = (idx%3)*3;
            for (int i = 0; i < N; ++i) {
                int rowIdx = i/3 + rowOffset;
                int colIdx = i%3 + colOffset;
                if (board[rowIdx][colIdx] != '.' && !charSet.add(board[rowIdx][colIdx])) {
                    return false;
                }
            }
            charSet.clear();
        }
        return true;
    }
}
