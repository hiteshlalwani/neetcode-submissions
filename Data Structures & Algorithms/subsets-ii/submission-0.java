class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 1. Sort to handle duplicates
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> res) {
        // Every path we take is a valid subset
        res.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // 2. Skip duplicates at the same level of recursion
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3. Include nums[i] and move forward
            current.add(nums[i]);
            backtrack(nums, i + 1, current, res);
            
            // 4. Backtrack
            current.remove(current.size() - 1);
        }
    }
}