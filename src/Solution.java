import java.util.Arrays;

class Solution {

    public int maxProfit(int k, int[] prices) {
        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, -prices[0]);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                buys[j] = Math.max(buys[j], -prices[i] + (j > 0 ? sells[j - 1] : 0));
                sells[j] = Math.max(sells[j], prices[i] + buys[j]);
            }
        }
        return sells[k - 1];
    }
}