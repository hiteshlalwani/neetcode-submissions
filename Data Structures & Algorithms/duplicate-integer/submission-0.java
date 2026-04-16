class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Arrays.sort(nums);
        for (int i = 0; i+1 < nums.length; ++i) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}