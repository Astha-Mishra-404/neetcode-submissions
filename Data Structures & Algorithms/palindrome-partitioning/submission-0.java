class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(0, s, path, res);
        return res;
    }

    private void dfs(int start, String s, List<String> path, List<List<String>> res) {

        // base case: reached end of string
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));

                dfs(end + 1, s, path, res);

                path.remove(path.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
