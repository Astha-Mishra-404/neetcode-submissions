class Solution {

    private int count = 0;
    private HashSet<Integer> cols = new HashSet<>();
    private HashSet<Integer> diag1 = new HashSet<>(); // row - col
    private HashSet<Integer> diag2 = new HashSet<>(); // row + col

    public int totalNQueens(int n) {
        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) ||
                diag1.contains(row - col) ||
                diag2.contains(row + col)) {
                continue;
            }

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(row + 1, n);

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}