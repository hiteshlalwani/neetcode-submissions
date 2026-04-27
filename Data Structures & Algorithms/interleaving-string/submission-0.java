class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // If lengths don't match, it's impossible
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty s1 and s2 can form empty s3
        dp[0][0] = true;

        // Fill the first column: only using characters from s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill the first row: only using characters from s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Option 1: Current s3 char matches s1 AND previous prefix was valid
                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                // Option 2: Current s3 char matches s2 AND previous prefix was valid
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                
                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[m][n];
    }
}