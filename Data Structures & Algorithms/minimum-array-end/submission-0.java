class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1;
        long mask = 1;

        while (remaining > 0) {
            // If the current bit in result is 0, we can fill it
            if ((result & mask) == 0) {
                // Set the bit in result if the lowest bit of remaining is 1
                result |= (remaining & 1) * mask;
                remaining >>= 1;
            }
            mask <<= 1;
        }

        return result;
    }
}