class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            if (r == n - 1 && c == n - 1) {
                return time;
            }
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{
                        Math.max(time, grid[nr][nc]),
                        nr,
                        nc
                    });
                }
            }
        }
        
        return -1;
    }
}