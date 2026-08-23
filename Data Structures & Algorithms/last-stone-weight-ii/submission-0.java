class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 0/1 Knapsack: find the maximum subset sum <= target
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the largest possible subset sum s1 <= totalSum / 2
        for (int s1 = target; s1 >= 0; s1--) {
            if (dp[s1]) {
                return totalSum - 2 * s1;
            }
        }

        return 0;
    }
}