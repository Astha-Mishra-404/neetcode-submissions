class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        // dp[i] = true if index i is reachable
        boolean[] dp = new boolean[n];
        dp[0] = true;

        // Number of reachable positions in the current window
        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // Add index i - minJump to the window
            int add = i - minJump;
            if (add >= 0 && dp[add]) {
                reachable++;
            }

            // Remove index i - maxJump - 1 from the window
            int remove = i - maxJump - 1;
            if (remove >= 0 && dp[remove]) {
                reachable--;
            }

            // Current position can be reached if:
            // 1. It is '0'
            // 2. There is at least one reachable index
            //    in [i - maxJump, i - minJump]
            if (s.charAt(i) == '0' && reachable > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}