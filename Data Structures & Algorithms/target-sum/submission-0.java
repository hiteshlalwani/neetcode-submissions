class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Edge cases: target is unreachable if it's larger than totalSum
        // or if (target + totalSum) is odd (since 2 * sum(P) must be even)
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (target + totalSum) / 2;
        return countSubsets(nums, subsetTarget);
    }

    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make sum 0 (empty subset)

        for (int num : nums) {
            // Traverse backwards to ensure each number is used only once (0/1 Knapsack)
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}