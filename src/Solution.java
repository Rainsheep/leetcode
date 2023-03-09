class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buys = new int[n];
        int[] sells = new int[n];
        buys[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buys[i] = Math.max(buys[i - 1], (i >= 2 ? sells[i - 2] : 0) - prices[i]);
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
        }
        return sells[n - 1];
    }
}