class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] will store the number of ways to make change for amount i
        int[] dp = new int[amount + 1];
        
        // Base case: There is exactly 1 way to make an amount of 0 (by choosing no coins)
        dp[0] = 1;
        
        // Pick each coin one by one
        for (int coin : coins) {
            // Update the dp array for all amounts from 'coin' to 'amount'
            for (int i = coin; i <= amount; i++) {
                // Number of ways to reach 'i' is the current ways 
                // plus the ways to reach 'i - coin'
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}