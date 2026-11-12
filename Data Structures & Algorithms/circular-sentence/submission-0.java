
class Solution {
    public boolean isCircularSentence(String sentence) {

        String[] words = sentence.split(" ");

        int n = words.length;

        for (int i = 0; i < n; i++) {

            String current = words[i];
            String next = words[(i + 1) % n];

            // Check circular connection
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }
}

