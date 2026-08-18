class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Initialize dp array with maximum possible value (or n)
        Arrays.fill(dp, n);
        
        // Base case: 0 requires 0 squares
        dp[0] = 0;

        // Compute the minimum squares needed for every value from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s * s <= i; s++) {
                int square = s * s;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }
}