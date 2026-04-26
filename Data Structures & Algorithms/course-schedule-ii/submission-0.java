class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // 1. Build the adjacency list and track in-degrees
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int dependency = pre[1];
            adj[dependency].add(course);
            inDegree[course]++;
        }

        // 2. Add all courses with no prerequisites to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // 3. Process the queue
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[index++] = curr; // Add to our course schedule

            for (int neighbor : adj[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // 4. If we couldn't take all courses, return an empty array
        return index == numCourses ? result : new int[0];
    }
}