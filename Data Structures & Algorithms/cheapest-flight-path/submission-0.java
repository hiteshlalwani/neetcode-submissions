class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // prices[i] stores the min cost to reach city i
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // We can take at most k stops, which means at most k + 1 flights
        for (int i = 0; i <= k; i++) {
            // We use a copy to avoid using updated prices from the SAME iteration
            int[] tempPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int s = flight[0]; // source
                int d = flight[1]; // destination
                int p = flight[2]; // price

                // If the source city has been reached in a previous layer
                if (prices[s] != Integer.MAX_VALUE) {
                    if (prices[s] + p < tempPrices[d]) {
                        tempPrices[d] = prices[s] + p;
                    }
                }
            }
            // Update the main prices array with results from this "layer"
            prices = tempPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}