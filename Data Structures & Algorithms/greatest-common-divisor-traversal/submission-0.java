class Solution {
    
    // Disjoint Set Union (DSU) helper class
    static class DSU {
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

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                components--;
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        
        // Base case: single element is always trivially traversable
        if (n == 1) {
            return true;
        }

        DSU dsu = new DSU(n);
        
        // Map each prime factor to the first array index that contains it
        Map<Integer, Integer> primeToFirstIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            
            // If any value is 1 when n > 1, it cannot share gcd > 1 with any number
            if (val == 1) {
                return false;
            }

            // Find all prime factors of val
            for (int d = 2; d * d <= val; d++) {
                if (val % d == 0) {
                    if (primeToFirstIndex.containsKey(d)) {
                        dsu.union(i, primeToFirstIndex.get(d));
                    } else {
                        primeToFirstIndex.put(d, i);
                    }
                    
                    while (val % d == 0) {
                        val /= d;
                    }
                }
            }

            // If remaining val > 1, it is a prime factor
            if (val > 1) {
                if (primeToFirstIndex.containsKey(val)) {
                    dsu.union(i, primeToFirstIndex.get(val));
                } else {
                    primeToFirstIndex.put(val, i);
                }
            }
        }

        // All indices must be in the same connected component
        return dsu.components == 1;
    }
}