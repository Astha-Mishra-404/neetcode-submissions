class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        
        // Base case: There is 1 way to make a sum of 0 (by choosing nothing)
        dp[0] = 1;

        // Fill dp array for each total from 1 up to target
        for (int total = 1; total <= target; total++) {
            for (int num : nums) {
                if (total - num >= 0) {
                    dp[total] += dp[total - num];
                }
            }
        }

        return dp[target];
    }
}