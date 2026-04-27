class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (curSum + num < num) {
                curSum = num;
            } else {
                curSum += num;
            }
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
