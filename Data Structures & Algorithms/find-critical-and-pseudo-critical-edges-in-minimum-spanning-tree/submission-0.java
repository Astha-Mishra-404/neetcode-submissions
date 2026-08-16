class Solution {

    // Disjoint Set Union (DSU) helper class
    class DSU {

        int[] parent;
        int components;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            components = n;
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Path compression
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                components--;
                return true;
            }
            return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
        int n,
        int[][] edges
    ) {
        int m = edges.length;

        // Store original index along with each edge: [u, v, weight, originalIndex]
        int[][] extendedEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            extendedEdges[i][0] = edges[i][0];
            extendedEdges[i][1] = edges[i][1];
            extendedEdges[i][2] = edges[i][2];
            extendedEdges[i][3] = i; // Store original index
        }

        // Sort edges by weight
        Arrays.sort(extendedEdges, (a, b) -> Integer.compare(a[2], b[2]));

        // Calculate standard MST weight
        int stdWeight = getMstWeight(
            n,
            extendedEdges,
            edges,
            -1,
            -1
        );

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        // Test each edge
        for (int i = 0; i < m; i++) {
            // Check if critical by excluding edge i
            if (
                getMstWeight(n, extendedEdges, edges, i, -1) > stdWeight
            ) {
                critical.add(i);
            }
            // Check if pseudo-critical by force-including edge i
            else if (
                getMstWeight(n, extendedEdges, edges, -1, i) == stdWeight
            ) {
                pseudoCritical.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);
        return result;
    }

    // Helper method to calculate MST weight
    private int getMstWeight(
        int n,
        int[][] sortedEdges,
        int[][] originalEdges,
        int blockEdgeIdx,
        int forceEdgeIdx
    ) {
        DSU dsu = new DSU(n);
        int weight = 0;

        // Force-include edge if specified
        if (forceEdgeIdx != -1) {
            int u = originalEdges[forceEdgeIdx][0];
            int v = originalEdges[forceEdgeIdx][1];
            int w = originalEdges[forceEdgeIdx][2];

            dsu.union(u, v);
            weight += w;
        }

        // Standard Kruskal's
        for (int[] edge : sortedEdges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int originalIdx = edge[3];

            // Skip the blocked edge
            if (originalIdx == blockEdgeIdx) {
                continue;
            }

            if (dsu.union(u, v)) {
                weight += w;
            }
        }

        // If graph is not fully connected, return infinity
        if (dsu.components > 1) {
            return Integer.MAX_VALUE;
        }

        return weight;
    }
}