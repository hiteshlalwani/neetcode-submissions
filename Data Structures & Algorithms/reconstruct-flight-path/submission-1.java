class Solution {
    // We use a PriorityQueue to automatically keep destinations in lexicographical order
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Build the adjacency list
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        // 2. Start DFS from the required starting point "JFK"
        dfs("JFK");
        return res;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = adj.get(airport);
        
        // 3. Visit neighbors in lexicographical order
        while (destinations != null && !destinations.isEmpty()) {
            // Remove the ticket as we use it to ensure we use each exactly once
            dfs(destinations.poll());
        }
        
        // 4. Post-order: add the airport to the front of the list
        res.addFirst(airport);
    }
}