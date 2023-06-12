import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];
        int ans = 0;
        Arrays.fill(buy, Integer.MIN_VALUE);


        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k && j <= i; j++) {
                buy[j] = Math.max((j == 0 ? 0 : sell[j - 1]) - prices[i], buy[j]);
                sell[j] = Math.max(buy[j] + prices[i], sell[j]);
                ans = Math.max(ans, sell[j]);
            }
        }
        return ans;

    }
}