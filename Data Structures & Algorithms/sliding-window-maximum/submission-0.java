class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int idx = 0; idx < n; ++idx) {
            while (!queue.isEmpty() && queue.peekFirst() < idx - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[idx] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(idx);
            if (idx >= k-1) {
                res[idx-k+1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
