class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 1. Get topological order for rows and columns
        int[] rowOrder = topoSort(k, rowConditions);
        int[] colOrder = topoSort(k, colConditions);

        // 2. If a cycle exists in either condition, no valid matrix can be built
        if (rowOrder.length == 0 || colOrder.length == 0) {
            return new int[0][0];
        }

        // 3. Map each number (1 to k) to its assigned row and column index
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder[i]] = i;
            colPos[colOrder[i]] = i;
        }

        // 4. Populate the k x k matrix
        int[][] matrix = new int[k][k];
        for (int num = 1; num <= k; num++) {
            matrix[rowPos[num]][colPos[num]] = num;
        }

        return matrix;
    }

    // Helper: Kahn's Algorithm (BFS) for Topological Sorting
    private int[] topoSort(int k, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[k + 1];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[k];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all k nodes are processed, a cycle exists
        if (index != k) {
            return new int[0];
        }

        return order;
    }
}