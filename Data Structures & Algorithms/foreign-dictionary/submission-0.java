class Solution {
    public String foreignDictionary(String[] words) {
        // 1. Initialize Adjacency List and In-Degree Map
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // 2. Build the Graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            
            // Edge Case: If w2 is a prefix of w1 but shorter (e.g., "apple", "app")
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; 
            }

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break; // Only the first differing character defines the order
                }
            }
        }

        // 3. BFS (Topological Sort)
        Queue<Character> q = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);

            for (char neighbor : adj.get(cur)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // 4. Cycle Detection
        return sb.length() < inDegree.size() ? "" : sb.toString();
    }
}