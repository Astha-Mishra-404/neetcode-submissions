class Solution {
    public int countCharacters(String[] words, String chars) {
        // Step 1: Count frequencies of characters in chars
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        int totalLength = 0;
        
        // Step 2: Check each word
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean canForm = true;
            
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
            
            // Step 3: Compare word frequencies with chars frequencies
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    canForm = false;
                    break;
                }
            }
            
            // Step 4: Add length if the word can be formed
            if (canForm) {
                totalLength += word.length();
            }
        }
        
        return totalLength;
    }
}