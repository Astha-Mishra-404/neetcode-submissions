
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int count = 0;
        int res = n;

        int left = 0;

        for (int right = 0; right < 2 * n; right++) {

            // Expected character in pattern 010101...
            char expected = (right % 2 == 0) ? '0' : '1';

            // Count mismatch
            if (str.charAt(right) != expected) {
                count++;
            }

            // Maintain window size n
            if (right - left + 1 > n) {

                char leftExpected =
                    (left % 2 == 0) ? '0' : '1';

                if (str.charAt(left) != leftExpected) {
                    count--;
                }

                left++;
            }

            // Calculate minimum flips
            if (right - left + 1 == n) {
                res = Math.min(res, Math.min(count, n - count));
            }
        }

        return res;
    }
}

