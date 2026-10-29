class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Build Pascal's Triangle row by row
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);

            // Update from right to left
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}