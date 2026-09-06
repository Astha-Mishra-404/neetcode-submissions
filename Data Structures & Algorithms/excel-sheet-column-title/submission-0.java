class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Convert to 0-based indexing
            columnNumber--;

            // Get the current character
            char ch = (char) ('A' + (columnNumber % 26));
            result.append(ch);

            // Move to the next digit
            columnNumber /= 26;
        }

        // Characters were generated from right to left
        return result.reverse().toString();
    }
}