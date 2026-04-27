class Solution {
    private int[][] memo;
    private int[] newNums;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Pad the array with 1s at both ends
        newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];
        return dfs(1, n);
    }

    private int dfs(int left, int right) {
        // Base case: no balloons left in this range
        if (left > right) return 0;
        
        // Return cached result
        if (memo[left][right] != 0) return memo[left][right];

        int maxProfit = 0;
        // i is the LAST balloon to burst in the current range [left, right]
        for (int i = left; i <= right; i++) {
            // Coins gained from bursting balloon i last:
            // left-1 and right+1 are the balloons that remain after 
            // everything else in the range [left, right] is gone.
            int currentCoins = newNums[left - 1] * newNums[i] * newNums[right + 1];
            
            // Add profit from bursting balloons to the left and right of i
            int total = currentCoins + dfs(left, i - 1) + dfs(i + 1, right);
            
            maxProfit = Math.max(maxProfit, total);
        }

        memo[left][right] = maxProfit;
        return maxProfit;
    }
}