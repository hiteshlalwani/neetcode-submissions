class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            // If i is a power of 2, it becomes our new offset
            // (e.g., 1, 2, 4, 8, 16...)
            if (offset * 2 == i) {
                offset = i;
            }
            
            // The number of bits in i is 1 + bits in (i - offset)
            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }
}