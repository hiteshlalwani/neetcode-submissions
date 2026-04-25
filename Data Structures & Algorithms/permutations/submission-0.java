class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> res) {
        // Base case: if current permutation is the same length as nums, we found a complete one
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip this number if it's already in the current permutation
            if (used[i]) continue;

            // 1. Choose: Mark as used and add to current list
            used[i] = true;
            current.add(nums[i]);

            // 2. Explore: Recurse to find the next number
            backtrack(nums, current, used, res);

            // 3. Un-choose: Backtrack by removing and marking as unused
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}