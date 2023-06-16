class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] buy = new int[length];
        int[] sell = new int[length];
        buy[0] = -prices[0];
        for (int i = 1; i < length; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[length - 1];
    }
}