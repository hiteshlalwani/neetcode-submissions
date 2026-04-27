class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Total sum of [0, n] using Gauss' formula
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}