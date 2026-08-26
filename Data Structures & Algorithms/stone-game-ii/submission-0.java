class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        // memo[i][m] stores the maximum stones a player can get starting at index i with parameter m
        int[][] memo = new int[n][n + 1];
        
        // Suffix sums to quickly get the total stones remaining from index i to the end
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return dfs(0, 1, piles, memo, suffixSum);
    }
    
    private int dfs(int i, int M, int[] piles, int[][] memo, int[] suffixSum) {
        int n = piles.length;
        
        // Base case: If the player can take all the remaining piles, take them.
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        // Return cached result if already computed
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        
        int maxStones = 0;
        
        // Try all valid values for X
        for (int X = 1; X <= 2 * M; X++) {
            // The opponent will play optimally from the new state, leaving us with the rest
            int currentStones = suffixSum[i] - dfs(i + X, Math.max(M, X), piles, memo, suffixSum);
            maxStones = Math.max(maxStones, currentStones);
        }
        
        memo[i][M] = maxStones;
        return maxStones;
    }
}