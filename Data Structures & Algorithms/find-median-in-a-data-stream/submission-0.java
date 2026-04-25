class MedianFinder {
    private PriorityQueue<Integer> small; // Max-heap
    private PriorityQueue<Integer> large; // Min-heap

    public MedianFinder() {
        // Max-heap for the lower half
        small = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for the upper half (default)
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. Always push to small (max-heap) first
        small.add(num);

        // 2. Make sure every num in small is <= every num in large
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        // 3. Balance the sizes (difference should be at most 1)
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } else if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        } else if (large.size() > small.size()) {
            return (double) large.peek();
        } else {
            // Even number of elements: average of the two middle values
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}