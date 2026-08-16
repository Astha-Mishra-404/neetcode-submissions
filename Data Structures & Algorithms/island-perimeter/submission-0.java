class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Start with 4 sides for each land cell
                    perimeter += 4;

                    // If there is a neighbor land cell above, subtract shared border (2 sides)
                    if (r > 0 && grid[r - 1][c] == 1) {
                        perimeter -= 2;
                    }

                    // If there is a neighbor land cell to the left, subtract shared border (2 sides)
                    if (c > 0 && grid[r][c - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}