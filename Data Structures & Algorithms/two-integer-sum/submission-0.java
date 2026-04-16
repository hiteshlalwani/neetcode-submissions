class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length < 2) return res;

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (numMap.containsKey(target - nums[i])) {
                res[0] = numMap.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            numMap.put(nums[i], i);
        }
        return res;
    }
}
