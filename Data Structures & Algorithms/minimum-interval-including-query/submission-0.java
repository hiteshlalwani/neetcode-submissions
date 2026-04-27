class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;

        // 1. Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Keep track of original query indices so we can return result in order
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        // Sort queries by their value
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Min-Heap stores [interval_length, interval_end_time]
        // It is ordered primarily by length (shortest first)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[m];
        int i = 0; // Pointer for intervals

        for (int j = 0; j < m; j++) {
            int queryVal = sortedQueries[j][0];
            int originalIdx = sortedQueries[j][1];

            // Add all intervals that start before or at the current query value
            while (i < n && intervals[i][0] <= queryVal) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                minHeap.offer(new int[]{right - left + 1, right});
                i++;
            }

            // Remove intervals from the heap that end before the current query value
            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.poll();
            }

            // The shortest valid interval is at the top of the heap
            result[originalIdx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
}