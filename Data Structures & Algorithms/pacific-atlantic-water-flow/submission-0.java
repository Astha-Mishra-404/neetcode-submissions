class Solution {
    int rows, cols;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Pacific (top + left)
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
        }
        
        // Atlantic (bottom + right)
        for (int c = 0; c < cols; c++) {
            dfs(rows - 1, c, atlantic, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, cols - 1, atlantic, heights);
        }
        
        // Collect result
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;
        
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
            if (visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            
            dfs(nr, nc, visited, heights);
        }
    }
}