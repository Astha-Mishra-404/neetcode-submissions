class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxLen = 1 << n;
        int[] p = new int[maxLen]; // Stores length if mask is a palindrome, 0 otherwise

        // Step 1: Find all palindromic subsequences and store their lengths
        for (int mask = 1; mask < maxLen; mask++) {
            if (isPalindrome(s, mask)) {
                p[mask] = Integer.bitCount(mask);
            }
        }

        // Step 2: Find the maximum product of two disjoint palindromic subsequences
        int res = 0;
        for (int m1 = 1; m1 < maxLen; m1++) {
            if (p[m1] == 0) continue;
            for (int m2 = 1; m2 < maxLen; m2++) {
                if ((m1 & m2) == 0 && p[m2] > 0) {
                    res = Math.max(res, p[m1] * p[m2]);
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int mask) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && (mask & (1 << l)) == 0) {
                l++;
            }
            while (l < r && (mask & (1 << r)) == 0) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
