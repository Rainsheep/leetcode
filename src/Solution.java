class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int ans = 0;
        for (int price : prices) {
            ans = Math.max(ans, price - min);
            min = Math.min(min, price);
        }
        return ans;
    }
}