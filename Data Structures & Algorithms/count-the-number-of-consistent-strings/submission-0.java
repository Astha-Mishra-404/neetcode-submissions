class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Store allowed characters in a HashSet
        Set<Character> allowedSet = new HashSet<>();

        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;

        // Check each word
        for (String word : words) {
            boolean isConsistent = true;

            for (char c : word.toCharArray()) {
                // If any character is not allowed
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }

            // Count only consistent words
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}