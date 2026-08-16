class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // isPre[i][j] will be true if course i is a prerequisite of course j
        boolean[][] isPre = new boolean[numCourses][numCourses];
        
        // Direct prerequisites
        for (int[] p : prerequisites) {
            isPre[p[0]][p[1]] = true;
        }
        
        // Floyd-Warshall algorithm for transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPre[i][k] && isPre[k][j]) {
                        isPre[i][j] = true;
                    }
                }
            }
        }
        
        // Answer each query in O(1) time
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(isPre[q[0]][q[1]]);
        }
        
        return ans;
    }
}