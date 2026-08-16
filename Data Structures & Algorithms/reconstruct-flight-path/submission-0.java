
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Graph: src -> min heap of destinations
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph
                .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", graph, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> pq = graph.get(airport);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll(); // smallest lex destination
            dfs(next, graph, result);
        }
        
        result.addFirst(airport); // post-order
    }
}