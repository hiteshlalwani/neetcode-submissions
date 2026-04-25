class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone : stones) {
            q.offer(stone);
        }
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if (a != b) {
                q.offer(a-b);
            }
        }
        return (!q.isEmpty()) ? q.poll() : 0;
    }
}
