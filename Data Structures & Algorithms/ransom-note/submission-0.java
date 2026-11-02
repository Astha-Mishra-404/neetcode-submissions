
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Count frequency of each character in magazine
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;

            // Not enough characters available
            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
