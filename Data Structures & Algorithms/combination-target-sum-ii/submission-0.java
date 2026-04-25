class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // Essential for skipping duplicates
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 1. Skip duplicates at the same recursive level
            // If the current number is the same as the previous one in this loop,
            // it would lead to a duplicate combination.
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // 2. Early Exit (Pruning)
            if (candidates[i] > target) break;

            cur.add(candidates[i]);
            // 3. Move to 'i + 1' because we cannot reuse the same element
            backtrack(candidates, i + 1, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}