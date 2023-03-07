import java.util.Arrays;

class Solution {

    int space;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        this.space = amount;
        dp = new int[space + 1];
        int defaultMax = Integer.MAX_VALUE - 1;
        Arrays.fill(dp, defaultMax);
        dp[0] = 0;
        for (int coin : coins) {
            completePack(coin, 1);
        }
        return dp[space] == defaultMax ? -1 : dp[space];
    }

    private void completePack(int weight, int value) {
        for (int i = weight; i <= space; i++) {
            dp[i] = Math.min(dp[i], dp[i - weight] + value);
        }
    }
}