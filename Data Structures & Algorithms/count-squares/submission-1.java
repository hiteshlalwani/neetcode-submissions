class CountSquares {
    // Store counts of each point. Using a List to track all unique points
    // for faster iteration during the count() operation.
    private Map<String, Integer> pointCounts;
    private List<int[]> points;

    public CountSquares() {
        pointCounts = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        pointCounts.put(key, pointCounts.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;

        for (int[] p : points) {
            int x2 = p[0];
            int y2 = p[1];

            // Check if (x2, y2) can be the diagonal opposite of (x1, y1)
            // 1. Must be a square: abs(x1-x2) == abs(y1-y2)
            // 2. Area must be > 0: x1 != x2
            if (Math.abs(x1 - x2) != Math.abs(y1 - y2) || x1 == x2) {
                continue;
            }

            // The other two points needed are (x1, y2) and (x2, y1)
            String p2 = x1 + "," + y2;
            String p4 = x2 + "," + y1;

            if (pointCounts.containsKey(p2) && pointCounts.containsKey(p4)) {
                totalSquares += pointCounts.get(p2) * pointCounts.get(p4);
            }
        }

        return totalSquares;
    }
}