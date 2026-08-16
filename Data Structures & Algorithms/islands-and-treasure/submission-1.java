class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure cells (0) to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions: up, down, left, right
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check bounds and only process INF cells
                if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                    && grid[nr][nc] == Integer.MAX_VALUE) {
                    
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
