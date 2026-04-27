class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        
        // Start with the first interval
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            // Step 2: Check for overlap
            // If the next interval starts before or at the current interval's end
            if (nextStart <= currentEnd) {
                // Merge them by updating the end time to the maximum of both
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}