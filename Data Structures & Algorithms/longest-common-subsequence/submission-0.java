class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // dp[i][j] stores the LCS length for text1[i...] and text2[j...]
        // We use size (m+1)x(n+1) to handle the empty string base cases
        int[][] dp = new int[m + 1][n + 1];

        // Iterate backwards from the end of both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // If characters match, add 1 to the result of the remaining strings
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // If they don't match, take the best result from skipping 
                    // either one character of text1 or one character of text2
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}