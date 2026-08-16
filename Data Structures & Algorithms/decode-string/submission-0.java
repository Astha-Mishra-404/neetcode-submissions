class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Formulate the full number (handles multi-digit numbers like 10, 100)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and the string built so far onto their stacks
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset for the new context inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the multiplier and the preceding string context
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Append the current inner string 'repeatTimes' times to the previous context
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                
                // Update currentString to hold the newly combined result
                currentString = decodedString;
            } else {
                // Regular character, just append to our current working string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}