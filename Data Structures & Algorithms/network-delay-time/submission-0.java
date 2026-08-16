
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build graph (adjacency list)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                 .add(new int[]{t[1], t[2]});
        }

        // Step 2: Min-heap (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (time > dist[node]) continue;

            if (!graph.containsKey(node)) continue;

            for (int[] nei : graph.get(node)) {
                int nextNode = nei[0];
                int newTime = time + nei[1];

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }

        // Step 5: Get answer
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}