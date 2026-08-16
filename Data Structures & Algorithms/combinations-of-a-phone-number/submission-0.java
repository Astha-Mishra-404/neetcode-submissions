class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, digits, map, new StringBuilder(), 0);

        return result;
    }

    private void backtrack(List<String> result, String digits, String[] map, StringBuilder current, int index) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, map, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}