class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];

        // Base cases
        buy[0] = -prices[0];
        sell[0] = 0;
        
        // On day 1, we either buy on day 0 or day 1 (whichever is cheaper)
        buy[1] = Math.max(buy[0], -prices[1]);
        // On day 1, we either sell the stock we bought on day 0 or stay at 0
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < n; i++) {
            // buy[i]: We either rest (buy[i-1]) or buy today.
            // If we buy today, we must have been in "cooldown" (sell[i-2])
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            
            // sell[i]: We either rest (sell[i-1]) or sell today.
            // If we sell today, we must have been holding the stock (buy[i-1])
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[n - 1];
    }
}