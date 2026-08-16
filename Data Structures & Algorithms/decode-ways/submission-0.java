class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        // dp[i+1] and dp[i+2]
        int next1 = 1; // dp[n]
        int next2 = 0; // dp[n+1] (not used initially)
        
        for (int i = n - 1; i >= 0; i--) {
            int curr = 0;
            
            // Single digit
            if (s.charAt(i) != '0') {
                curr = next1;
                
                // Two digits
                if (i + 1 < n) {
                    int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                    if (num >= 10 && num <= 26) {
                        curr += next2;
                    }
                }
            }
            
            next2 = next1;
            next1 = curr;
        }
        
        return next1;
    }
}
