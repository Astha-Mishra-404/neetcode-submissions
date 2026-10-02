class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        // Find maximum odd frequency
        // and minimum even frequency
        for (int count : freq) {
            if (count == 0) {
                continue;
            }

            if (count % 2 == 1) {
                maxOdd = Math.max(maxOdd, count);
            } else {
                minEven = Math.min(minEven, count);
            }
        }

        return maxOdd - minEven;
    }
}