class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a Max-Heap based on squared distance
        // (b[0]^2 + b[1]^2) - (a[0]^2 + a[1]^2)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = pq.poll();
        }
        return res;
    }
}