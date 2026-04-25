class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        populateCombinationSumRecur(nums, 0, target, visited, new ArrayList<>(), res);
        return res;
    }

    private void populateCombinationSumRecur(int[] nums, int pos, int target, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int idx = pos; idx < nums.length; ++idx) {
            if (idx > 0 && nums[idx] == nums[idx-1] && !visited[idx-1]) continue;
            if (nums[idx] > target) break;
            visited[idx] = true;
            cur.add(nums[idx]);
            populateCombinationSumRecur(nums, idx, target - nums[idx], visited, cur, res);
            cur.remove(cur.size()-1);
            visited[idx] = false;
        }
    }
}
