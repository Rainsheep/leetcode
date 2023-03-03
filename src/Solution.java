import java.util.Arrays;

class Solution {

    int space;
    int[] dp;

    public int numSquares(int n) {
        space = n;
        dp = new int[space + 1];
        int sqrt = (int) Math.sqrt(n);
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= sqrt; i++) {
            completePack(i * i, 1);
        }

        return dp[space];
    }

    private void completePack(int weight, int value) {
        for (int i = weight; i <= space; i++) {
            dp[i] = Math.min(dp[i], dp[i - weight] + value);
        }
    }
}