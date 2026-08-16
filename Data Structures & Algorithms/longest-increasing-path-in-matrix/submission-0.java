class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int[][] dp;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];

        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        int max = 1; // at least the cell itself

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && nj >= 0 && ni < m && nj < n 
                && matrix[ni][nj] > matrix[i][j]) {
                
                max = Math.max(max, 1 + dfs(matrix, ni, nj));
            }
        }

        dp[i][j] = max;
        return max;
    }
}