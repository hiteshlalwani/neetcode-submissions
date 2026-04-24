class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (++count[num] >= 2) {
                return num;
            }
        }
        return -1;
    }
}
