import java.util.Arrays;

class Solution {

    public int maxProfit(int[] prices) {
        int k = 2;

        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, -prices[0]);
        for (int price : prices) {
            for (int j = 0; j < k; j++) {
                buys[j] = Math.max(buys[j], -price + (j > 0 ? sells[j - 1] : 0));
                sells[j] = Math.max(sells[j], buys[j] + price);
            }
        }

        return sells[k - 1];
    }
}