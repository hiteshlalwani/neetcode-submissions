class KthLargest {

    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();  // min heap to track top k
        this.k = k;
        for (int num : nums) {
            if (!(pq.size() >= k && num < pq.peek())) this.pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        System.out.println("pq = " + pq);
    }
    
    public int add(int val) {
        if (!(pq.size() >= this.k && val < pq.peek())) this.pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
