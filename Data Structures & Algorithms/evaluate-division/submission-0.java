class Solution {
    private static class Node {
        String var;
        double weight;

        Node(String var, double weight) {
            this.var = var;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the adjacency list
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Node(v, val));
            graph.get(v).add(new Node(u, 1.0 / val));
        }

        // Step 2: Process queries via DFS
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else if (src.equals(dest)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(src, dest, 1.0, graph, visited);
            }
        }

        return result;
    }

    private double dfs(String src, String dest, double acc, Map<String, List<Node>> graph, Set<String> visited) {
        visited.add(src);

        if (src.equals(dest)) {
            return acc;
        }

        for (Node neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.var)) {
                double ans = dfs(neighbor.var, dest, acc * neighbor.weight, graph, visited);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }

        return -1.0;
    }
}