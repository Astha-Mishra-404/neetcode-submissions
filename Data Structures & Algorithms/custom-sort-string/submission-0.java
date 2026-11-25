
class Solution {
    public String customSortString(String order, String s) {
        // Step 1: Count frequency of each character
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Add characters in the given order
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }

        // Step 3: Add remaining characters
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result.append((char) (i + 'a'));
                count[i]--;
            }
        }

        return result.toString();
    }
}
