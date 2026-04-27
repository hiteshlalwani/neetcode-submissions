class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize a Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // Add current element to the heap
            minHeap.offer(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
}