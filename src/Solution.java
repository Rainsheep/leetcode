import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    ArrayList<Integer> weights = new ArrayList<>();
    int space;
    int[] dp;

    public int numSquares(int n) {
        fillWeight(n);
        this.space = n;
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (Integer weight : weights) {
            complatePack(weight, 1);
        }
        return dp[n];
    }

    private void complatePack(int weight, int value) {
        for (int i = weight; i <= space; i++) {
            dp[i] = Math.min(dp[i], dp[i - weight] + value);
        }
    }

    private void fillWeight(int n) {
        int i = 1;
        while (i * i <= n) {
            weights.add(i * i);
            i++;
        }
    }

}