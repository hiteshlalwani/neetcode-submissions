class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int course = 0; course < numCourses; ++course) {
            adj[course] = new ArrayList<>();
        }

        int[] inDeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            inDeg[a]++; // b-> a edge so indegree a++
            adj[b].add(a);  // add edge
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int course = 0; course < numCourses; ++course) {
            if (inDeg[course] == 0) {
                q.offer(course);
            }
        }

        int coveredCourse = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            coveredCourse++;
            for (int next : adj[cur]) {
                inDeg[next]--;
                if (inDeg[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return coveredCourse == numCourses;
    }
}
