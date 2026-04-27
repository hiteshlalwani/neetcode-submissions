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

// class Solution {
//     public List<int[]> getNonOverlappingIntervals(int[][] intervals) {
//         if (intervals.length == 0) return new ArrayList<>();

//         // Step 1: Sort intervals by their start time
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         List<int[]> result = new ArrayList<>();
//         // Always keep the first interval as a starting point
//         int[] prev = intervals[0];
//         result.add(prev);

//         for (int i = 1; i < intervals.length; i++) {
//             int[] curr = intervals[i];
            
//             // Check for overlap: current start < previous end
//             if (curr[0] < prev[1]) {
//                 // Overlap found! We must "remove" one.
//                 // Greedy Choice: Keep the one that ends earlier.
//                 if (curr[1] < prev[1]) {
//                     // The current one ends earlier, so it's "safer" to keep.
//                     // Replace the last added interval in our result list.
//                     result.remove(result.size() - 1);
//                     result.add(curr);
//                     prev = curr;
//                 }
//                 // Else: the previous one ended earlier, so we just "discard" curr
//                 // (do nothing, result remains the same)
//             } else {
//                 // No overlap: This interval is safe to keep
//                 result.add(curr);
//                 prev = curr;
//             }
//         }

//         return result;
//     }
// }