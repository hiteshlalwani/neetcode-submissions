class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // 1. Count frequencies
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // 2. Max-Heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) maxHeap.offer(c);
        }

        int time = 0;
        // Queue stores pairs: [remaining_frequency, time_available_to_use_again]
        Queue<int[]> queue = new LinkedList<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll() - 1;
                if (val > 0) {
                    // Task still has remaining runs, add to cooldown queue
                    queue.offer(new int[]{val, time + n});
                }
            }

            // Check if any task in the queue has finished its cooldown
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}