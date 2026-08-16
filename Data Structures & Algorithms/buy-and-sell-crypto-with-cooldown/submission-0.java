class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int buy = -prices[0];
        int sell = 0;
        int cool = 0;

        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            int prevCool = cool;

            buy = Math.max(prevBuy, prevCool - prices[i]);
            sell = prevBuy + prices[i];
            cool = Math.max(prevCool, prevSell);
        }

        return Math.max(sell, cool);
    }
}