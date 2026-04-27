class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; ++i) {
            for (int val = coins[i]; val <= amount; val++) {
                if (dp[val-coins[i]] != Integer.MAX_VALUE) {
                    dp[val] = Math.min(dp[val], 1 + dp[val-coins[i]]);
                }
            }
        }
        return (dp[amount] != Integer.MAX_VALUE) ? dp[amount] : -1;
    }
}
