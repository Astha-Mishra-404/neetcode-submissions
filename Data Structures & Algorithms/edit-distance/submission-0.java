
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] will be the edit distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from word1 to match empty word2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters from word2 into empty word1
        }
        
        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min of (Insert, Delete, Replace) + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                   Math.min(dp[i - 1][j],    // Delete
                                            dp[i][j - 1]));  // Insert
                }
            }
        }
        
        return dp[m][n];
    }
}