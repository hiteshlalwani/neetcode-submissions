class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // We can use the variables to track the min cost to reach
        // the step two-behind and one-behind our current position.
        int downTwo = cost[0];
        int downOne = cost[1];
        
        // Start from index 2 because we can naturally start at 0 or 1
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(downTwo, downOne);
            downTwo = downOne;
            downOne = current;
        }
        
        // The answer is the minimum of the last two steps because 
        // you can reach the top from either of them.
        return Math.min(downTwo, downOne);
    }
}