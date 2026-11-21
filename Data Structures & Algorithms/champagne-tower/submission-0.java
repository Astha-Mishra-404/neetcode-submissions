class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prevRow = new double[] { poured };

        for (int row = 1; row <= query_row; row++) {
            double[] currRow = new double[row + 1];

            for (int col = 0; col < prevRow.length; col++) {
                double excess = prevRow[col] - 1.0;
                if (excess > 0) {
                    currRow[col] += excess / 2.0;
                    currRow[col + 1] += excess / 2.0;
                }
            }

            prevRow = currRow;
        }

        return Math.min(1.0, prevRow[query_glass]);
    }
}