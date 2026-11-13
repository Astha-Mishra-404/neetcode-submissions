
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // Store the first occurrence of each character
        int[] first = new int[26];
        Arrays.fill(first, -1);

        int maxLen = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            // If character is seen for the first time
            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                // Calculate length excluding both characters
                maxLen = Math.max(maxLen, i - first[idx] - 1);
            }
        }

        return maxLen;
    }
}
