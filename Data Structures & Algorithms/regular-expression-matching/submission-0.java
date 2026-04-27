class Solution {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        // Return cached result if available
        if (memo[i][j] != null) return memo[i][j];

        // Base Case: If we reached the end of the pattern
        if (j >= p.length()) {
            return i >= s.length();
        }

        // Check if the current characters match
        boolean match = i < s.length() && 
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Handle the '*' wildcard
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Don't use the '*' (skip it and its preceding character)
            // Choice 2: Use the '*' (if there was a match, move to next char in s)
            memo[i][j] = dfs(i, j + 2, s, p) || 
                         (match && dfs(i + 1, j, s, p));
        } else {
            // No wildcard: move both pointers if there's a match
            memo[i][j] = match && dfs(i + 1, j + 1, s, p);
        }

        return memo[i][j];
    }
}