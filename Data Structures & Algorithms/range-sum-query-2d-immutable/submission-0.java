class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create prefix sum matrix with extra row & column
        prefix = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                prefix[r + 1][c + 1] =
                        matrix[r][c]
                        + prefix[r][c + 1]
                        + prefix[r + 1][c]
                        - prefix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1++;
        col1++;
        row2++;
        col2++;

        return prefix[row2][col2]
                - prefix[row1 - 1][col2]
                - prefix[row2][col1 - 1]
                + prefix[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */