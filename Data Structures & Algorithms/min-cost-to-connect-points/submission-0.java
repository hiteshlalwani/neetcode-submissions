class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost = 0;
        int edgesUsed = 0;
        
        // dist[i] stores the minimum distance to connect points[i] to the current MST
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        boolean[] inMST = new boolean[n];
        
        while (edgesUsed < n) {
            int curr = -1;
            
            // 1. Find the node with the smallest distance that is NOT yet in the MST
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (curr == -1 || minDist[i] < minDist[curr])) {
                    curr = i;
                }
            }
            
            // 2. Add this node to the MST
            inMST[curr] = true;
            minCost += minDist[curr];
            edgesUsed++;
            
            // 3. Update the distances of all neighbors (all other points)
            for (int next = 0; next < n; next++) {
                if (!inMST[next]) {
                    int weight = Math.abs(points[curr][0] - points[next][0]) + 
                                 Math.abs(points[curr][1] - points[next][1]);
                    
                    if (weight < minDist[next]) {
                        minDist[next] = weight;
                    }
                }
            }
        }
        
        return minCost;
    }
}