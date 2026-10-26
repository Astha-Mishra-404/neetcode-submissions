
class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] count = new int[26];

        // Count every character across all strings
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        // Each character must be distributed equally
        for (int freq : count) {
            if (freq % n != 0) {
                return false;
            }
        }

        return true;
    }
}
