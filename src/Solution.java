class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for (int price : prices) {
            int t = sell;
            sell = Math.max(sell, buy + price - fee);
            buy = Math.max(buy, t - price);
        }
        return sell;
    }
}