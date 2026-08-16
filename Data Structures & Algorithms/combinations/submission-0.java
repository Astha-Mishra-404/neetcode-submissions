class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination of size k found
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop through candidate numbers
        // Optimization: Stop if there aren't enough elements remaining to reach size k
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);                            // Make decision
            backtrack(i + 1, n, k, current, result);   // Explore
            current.remove(current.size() - 1);        // Undo decision (Backtrack)
        }
    }
}