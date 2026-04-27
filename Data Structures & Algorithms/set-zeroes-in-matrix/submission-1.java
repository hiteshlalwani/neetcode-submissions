class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstColZero = false;

        for (int r = 0; r < rows; r++) {
            // Check if the first column itself should be zeroed later
            if (matrix[r][0] == 0) firstColZero = true;

            // Start 'c' from 1 so we don't overwrite the first column marker yet
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Use the markers to zero out the interior (skip row 0 and col 0)
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero out the first row if the top-left marker is 0
        if (matrix[0][0] == 0) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        // Zero out the first column based on our dedicated flag
        if (firstColZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}