class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        // Keep track of the end time of the last interval we "kept"
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Check if the current interval overlaps with the previous one
            if (currentStart < prevEnd) {
                // Overlap found! Increment the removal count
                count++;
                // Greedy Choice: Keep the interval that ends earlier 
                // to minimize the chance of overlapping with the next one
                prevEnd = Math.min(prevEnd, currentEnd);
            } else {
                // No overlap: Update prevEnd to the current interval's end
                prevEnd = currentEnd;
            }
        }

        return count;
    }
}