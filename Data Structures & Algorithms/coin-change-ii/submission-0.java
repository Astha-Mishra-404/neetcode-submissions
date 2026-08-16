class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] will store the number of ways to make amount i
        int[] dp = new int[amount + 1];
        
        // Base case: there is 1 way to make amount 0 (using no coins)
        dp[0] = 1;
        
        // Iterate through each coin first to ensure we only find combinations, 
        // not permutations.
        for (int coin : coins) {
            // Update the dp array for all amounts that can be reached using this coin
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}