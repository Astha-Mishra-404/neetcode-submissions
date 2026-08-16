class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min heap based on required capital
        PriorityQueue<int[]> minCapital =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Max heap based on profit
        PriorityQueue<Integer> maxProfit =
                new PriorityQueue<>((a, b) -> b - a);

        int n = profits.length;

        // Store (capital, profit)
        for (int i = 0; i < n; i++) {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {

            // Add all projects that are affordable
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfit.offer(minCapital.poll()[1]);
            }

            // No project can be done
            if (maxProfit.isEmpty()) {
                break;
            }

            // Do the most profitable project
            w += maxProfit.poll();
        }

        return w;
    }
}
