class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] = number of ways to form t[0..j-1]
        long[] dp = new long[n + 1];
        
        dp[0] = 1; // empty t
        
        for (int i = 1; i <= m; i++) {
            // traverse backwards to avoid overwriting
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return (int) dp[n];
    }
}