class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses]; // 0,1,2

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i)) {
                return false; // cycle found
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) return true;  // cycle
        if (visited[node] == 2) return false; // already safe

        visited[node] = 1; // mark visiting

        for (int nei : graph.get(node)) {
            if (dfs(graph, visited, nei)) {
                return true;
            }
        }

        visited[node] = 2; // mark safe
        return false;
    }
}
