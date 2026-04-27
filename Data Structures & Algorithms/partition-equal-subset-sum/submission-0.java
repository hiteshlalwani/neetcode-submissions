class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;

        int target = totalSum/2;
        return isTargetSum(nums, target);
    }

    private boolean isTargetSum(int[] nums, int target) {
        if (nums.length == 0) return false;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : nums) {
            for (int val = target; val >= num; val--) {
                if (dp[val - num]) {
                    dp[val] = true;
                }
            }
        }
        return dp[target];
    }
}
