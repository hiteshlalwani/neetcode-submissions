class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(maxHouseRob(nums, 0, nums.length-2), maxHouseRob(nums, 1, nums.length-1));
    }

    private int maxHouseRob(int[] nums, int left, int right) {
        int[] dp = new int[right-left+1];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left+1]);
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[left + i]);
        }
        return dp[dp.length-1];
    }
}
