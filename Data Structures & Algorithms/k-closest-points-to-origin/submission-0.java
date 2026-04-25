class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k <= 0 || points == null || points.length == 0) return new int[0][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(getDistanceFromOrigin(b), getDistanceFromOrigin(a)));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            res[idx][0] = point[0];
            res[idx][1] = point[1];
            idx++;
        }
        return res;
    }

    private double getDistanceFromOrigin(int[] point) {
        return Math.sqrt(point[0]*point[0] + point[1]*point[1]);
    }
}
