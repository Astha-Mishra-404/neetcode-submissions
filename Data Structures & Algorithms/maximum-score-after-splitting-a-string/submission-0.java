
class Solution {
    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;

        // Count total ones in the string
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        int maxScore = 0;

        // Try every valid split
        for (int i = 0; i < s.length() - 1; i++) {

            // Count zeros in the left substring
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }

            // Calculate current score
            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }
}
