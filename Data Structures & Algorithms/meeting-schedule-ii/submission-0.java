/**
 * Definition of Interval:
 * public class Interval {
 * public int start, end;
 * public Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        // 1. Sort meetings by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 2. Min-heap stores end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first meeting's end time
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            // If the room with the earliest end time is free
            if (intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll(); // Reuse the room
            }
            
            // Occupy the room (either a new one or the reused one)
            minHeap.offer(intervals.get(i).end);
        }

        // The size of the heap is the total rooms required
        return minHeap.size();
    }
}

// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         int n = intervals.size();
//         int[] starts = new int[n];
//         int[] ends = new int[n];

//         for (int i = 0; i < n; i++) {
//             starts[i] = intervals.get(i).start;
//             ends[i] = intervals.get(i).end;
//         }

//         Arrays.sort(starts);
//         Arrays.sort(ends);

//         int res = 0, count = 0;
//         int s = 0, e = 0;

//         while (s < n) {
//             if (starts[s] < ends[e]) {
//                 // Meeting started before another ended: need a room
//                 count++;
//                 s++;
//             } else {
//                 // A meeting ended: free up a room
//                 count--;
//                 e++;
//             }
//             res = Math.max(res, count);
//         }

//         return res;
//     }
// }