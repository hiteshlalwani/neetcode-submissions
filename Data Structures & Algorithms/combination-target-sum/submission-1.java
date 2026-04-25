class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort to allow early exit
        backtrack(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Early Exit: since nums is sorted, if this is too big, 
            // all subsequent numbers will also be too big.
            if (nums[i] > target) break;

            cur.add(nums[i]);
            // Use 'i' instead of 'i + 1' to allow reusing the same element
            backtrack(nums, i, target - nums[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}