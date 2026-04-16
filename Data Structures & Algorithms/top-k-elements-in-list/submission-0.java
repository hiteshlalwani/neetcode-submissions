class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new int[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // {num, freq} - order by frequency increasing order
        Queue<int[]> minHeap = new PriorityQueue<>( (a, b) -> (a[1] != b[1]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]) );
        for (int num : countMap.keySet()) {
            int freq = countMap.get(num);
            int[] pair = {num, freq};
            if (minHeap.isEmpty() || minHeap.size() < k) {
                minHeap.offer(pair);
            } else if (freq > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.offer(pair);
            }
        }
        int[] res = new int[minHeap.size()];
        for (int idx = 0; idx < res.length; ++idx) {
            res[idx] = minHeap.poll()[0];
        }
        return res;
    }
}
