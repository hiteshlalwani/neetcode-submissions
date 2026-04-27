class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (along the top row)
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // 2. Traverse Down (along the right column)
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // 3. Check if boundaries crossed after shifting top/right
            if (!(top <= bottom && left <= right)) break;

            // 4. Traverse Left (along the bottom row)
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--; // Move the bottom boundary up

            // 5. Traverse Up (along the left column)
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++; // Move the left boundary right
        }

        return res;
    }
}