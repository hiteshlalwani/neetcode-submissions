class Solution {
    public int uniquePaths(int m, int n) {
        // We only need one row of size n
        int[] row = new int[n];
        
        // Fill the first row with 1s (there's only 1 way to reach any cell in the top row)
        Arrays.fill(row, 1);
        
        // Iterate through each row starting from the second one (index 1)
        for (int i = 1; i < m; i++) {
            // New row values depend on the value to the left and the value above (stored in 'row')
            for (int j = 1; j < n; j++) {
                // row[j] is the value from the previous row
                // row[j-1] is the value from the current row to the left
                row[j] = row[j] + row[j - 1];
            }
        }
        
        return row[n - 1];
    }
}