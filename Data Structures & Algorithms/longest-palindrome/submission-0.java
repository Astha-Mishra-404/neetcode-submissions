
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        // Calculate palindrome length
        for (int freq : count) {
            length += (freq / 2) * 2;

            if (freq % 2 == 1) {
                hasOdd = true;
            }
        }

        // One odd character can be placed in the center
        if (hasOdd) {
            length++;
        }

        return length;
    }
}
