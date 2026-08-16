class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Take first string as initial prefix
        String prefix = strs[0];

        // Compare prefix with every string
        for (int i = 1; i < strs.length; i++) {

            // Reduce prefix until current string starts with it
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}