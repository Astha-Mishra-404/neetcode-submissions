
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();

        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }

        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Treat current character as extra
            dp[i] = 1 + dp[i + 1];

            // Try every substring starting at i
            for (int j = i; j < n; j++) {
                if (dict.contains(s.substring(i, j + 1))) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}