class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        // Initialize
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int components = n;
        
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) {
                components--; // merged two components
            }
        }
        
        return components;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }
    
    private boolean union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        
        if (rootX == rootY) return false;
        
        // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
}