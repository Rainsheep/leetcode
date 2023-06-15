import java.util.Arrays;

class Solution {
    int[] dp;
    int n;

    public int numSquares(int n) {
        this.n = n;
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int t = (int) Math.sqrt(n);
        for (int i = 1; i <= t; i++) {
            multiPack(i * i, 1);
        }
        return dp[n];
    }


    private void multiPack(int weight, int value) {
        for (int i = weight; i <= n; i++) {
            if (dp[i - weight] == Integer.MAX_VALUE) continue;
            dp[i] = Math.min(dp[i], dp[i - weight] + value);
        }
    }
}