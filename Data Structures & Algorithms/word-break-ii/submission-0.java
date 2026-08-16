class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return dfs(0, s, dict, memo);
    }

    private List<String> dfs(int start, String s, Set<String> dict,
                             Map<Integer, List<String>> memo) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> res = new ArrayList<>();

        // Reached end of string
        if (start == s.length()) {
            res.add("");
            return res;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            List<String> suffixes = dfs(end, s, dict, memo);

            for (String suffix : suffixes) {
                if (suffix.isEmpty()) {
                    res.add(word);
                } else {
                    res.add(word + " " + suffix);
                }
            }
        }

        memo.put(start, res);
        return res;
    }
}