class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if ((long)nums[i] <= (long)nums[i-1] + 1) {
                if (nums[i] != nums[i-1]) len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
        }
        return maxLen;
    }
}
