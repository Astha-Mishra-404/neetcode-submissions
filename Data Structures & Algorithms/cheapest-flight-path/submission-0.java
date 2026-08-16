class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] prices = new int[n];
        
        // Initialize prices
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Relax edges K+1 times
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if (prices[from] == Integer.MAX_VALUE) continue;

                if (prices[from] + cost < temp[to]) {
                    temp[to] = prices[from] + cost;
                }
            }

            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
