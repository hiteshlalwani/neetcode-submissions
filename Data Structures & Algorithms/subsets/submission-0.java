class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        populateSubsets(nums, 0, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void populateSubsets(int[] nums, int pos, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int idx = pos; idx < nums.length; ++idx) {
            if (!visited[idx]) {
                visited[idx] = true;
                cur.add(nums[idx]);
                populateSubsets(nums, idx + 1, visited, cur, res);
                visited[idx] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
