class Solution {
    public int integerBreak(int n) {
        // Base cases where k >= 2 constraint forces smaller products
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        
        // Base values when these numbers are used as factors in larger sums
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int maxProduct = 0;
            // Break i into j and (i - j)
            for (int j = 1; j <= i / 2; j++) {
                maxProduct = Math.max(maxProduct, dp[j] * dp[i - j]);
            }
            dp[i] = maxProduct;
        }

        return dp[n];
    }
}